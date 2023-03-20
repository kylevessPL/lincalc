package pl.piasta.lincalc.ui.main

import javafx.beans.property.SimpleStringProperty
import pl.piasta.lincalc.common.Constants.DECIMAL_DOT
import pl.piasta.lincalc.common.Constants.SIGN_MINUS
import pl.piasta.lincalc.common.Constants.ZERO
import pl.piasta.lincalc.common.EMPTY
import pl.piasta.lincalc.common.NaN
import pl.piasta.lincalc.common.isNaN
import pl.piasta.lincalc.common.toBigDecimal
import pl.piasta.lincalc.common.valueOrDefault
import pl.piasta.lincalc.math.MathExtensions.cos
import pl.piasta.lincalc.math.MathExtensions.percentage
import pl.piasta.lincalc.math.MathExtensions.sin
import pl.piasta.lincalc.math.MathExtensions.sqrt
import pl.piasta.lincalc.math.MathFunction
import pl.piasta.lincalc.math.MathFunction.COSINE
import pl.piasta.lincalc.math.MathFunction.NEGATION
import pl.piasta.lincalc.math.MathFunction.PERCENTAGE
import pl.piasta.lincalc.math.MathFunction.SINE
import pl.piasta.lincalc.math.MathFunction.SQUARE_ROOT
import pl.piasta.lincalc.math.MathOperator
import tornadofx.*

class MainViewModel : ViewModel() {
    val displayValue = SimpleStringProperty(ZERO)
    private var currentExpression = String.EMPTY
    private var latestOperator: MathOperator? = null

    fun clear() = displayValue.takeIf { !it.value.isNaN() }?.let {
        it.value = ZERO
    } ?: clearAll()

    fun clearAll() {
        displayValue.value = ZERO
        currentExpression = String.EMPTY
        latestOperator = null
    }

    fun doInput(input: String) = with(displayValue) {
        value = valueOrDefault(ZERO)
            .takeUnless { it == ZERO && input == ZERO }
            ?.let {
                if (it != ZERO) it + input else input
            } ?: ZERO
    }

    fun undoInput() = with(displayValue) {
        value = valueOrDefault(ZERO)
            .dropLast(1)
            .takeUnless { it == String.EMPTY || it == SIGN_MINUS + ZERO }
            ?: ZERO
    }

    fun convertToDecimal() {
        displayValue
            .valueOrDefault(ZERO)
            .takeUnless { it.contains(DECIMAL_DOT) }
            ?.let { displayValue.value = it + DECIMAL_DOT }
    }

    fun convertByFunction(function: MathFunction) {
        runAsync(true) {
            val number = displayValue.value.toBigDecimal()
            runCatching {
                when (function) {
                    SINE -> number.sin().toString()
                    COSINE -> number.cos().toString()
                    SQUARE_ROOT -> number.sqrt().toString()
                    PERCENTAGE -> number.percentage().toString()
                    NEGATION -> negateInput()
                }
            }.getOrDefault(String.NaN)
        } ui {
            displayValue.value = it
        }
    }

    private fun negateInput() = with(displayValue.value) {
        if (this != ZERO) {
            takeIf { startsWith(SIGN_MINUS) }
                ?.drop(1)
                ?: (SIGN_MINUS + this)
        } else this
    }
}
