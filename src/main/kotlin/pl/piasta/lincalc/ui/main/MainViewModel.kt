package pl.piasta.lincalc.ui.main

import javafx.beans.property.SimpleStringProperty
import pl.piasta.lincalc.common.Constants.DECIMAL_DOT
import pl.piasta.lincalc.common.Constants.SIGN_EQUALS
import pl.piasta.lincalc.common.Constants.SIGN_MINUS
import pl.piasta.lincalc.common.Constants.ZERO
import pl.piasta.lincalc.common.EMPTY
import pl.piasta.lincalc.common.NaN
import pl.piasta.lincalc.common.isNaN
import pl.piasta.lincalc.common.orDefault
import pl.piasta.lincalc.common.takeLastWhileInclusive
import pl.piasta.lincalc.common.toBigDecimal
import pl.piasta.lincalc.common.valueOrDefault
import pl.piasta.lincalc.math.MathEvaluator
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
    private var latestInput: String? = null

    fun clear() = displayValue.takeIf { !it.value.isNaN() }?.let {
        it.value = ZERO
        latestInput = null
    } ?: clearAll()

    fun clearAll() {
        displayValue.value = ZERO
        currentExpression = String.EMPTY
        latestInput = null
    }

    fun doInput(input: String) = with(displayValue) {
        if (currentExpression.endsWith(SIGN_EQUALS))
            currentExpression = String.EMPTY
        value = valueOrDefault(ZERO)
            .takeUnless { it == ZERO && input == ZERO }
            ?.let {
                if (it != ZERO && it == latestInput) it + input else input
            } ?: ZERO
        latestInput = value
        if (currentExpression.endsWith(SIGN_EQUALS))
            currentExpression = String.EMPTY
    }

    fun undoInput() = with(displayValue) {
        latestInput
            ?.dropLast(1)
            ?.let {
                value = if (!(it == String.EMPTY || it == SIGN_MINUS + ZERO))
                    it
                else ZERO
                latestInput = value
            }
    }

    fun evaluate() {
        if (currentExpression.isEmpty()) return
        runAsync {
            if (MathOperator.values().any { currentExpression.lastOrNull().toString() == it.sign }) {
                currentExpression += displayValue.value
            } else {
                val part = currentExpression
                    .dropLast(1)
                    .takeLastWhileInclusive { ch -> MathOperator.values().none { ch.toString() == it.sign } }
                currentExpression = displayValue.value + part
            }
            MathEvaluator.evaluateExpression(currentExpression)
                ?.stripTrailingZeros()
                ?.toString()
                ?: String.NaN
        } ui {
            displayValue.value = it
            currentExpression += SIGN_EQUALS
            latestInput = null
        }
    }

    fun doMathOperation(operation: MathOperator) {
        runAsync {
            if (latestInput.isNullOrEmpty() and
                MathOperator.values().any { currentExpression.lastOrNull().toString() == it.sign }
            ) {
                currentExpression = currentExpression.dropLast(1) + operation.sign
                return@runAsync null
            }
            if (currentExpression.endsWith(SIGN_EQUALS))
                currentExpression = ""
            currentExpression += displayValue.value + operation.sign
            MathEvaluator.evaluateExpression(currentExpression.dropLast(1))
                ?.stripTrailingZeros()
                ?.toString()
                ?: String.NaN
        } ui {
            it?.let { displayValue.value = it }
            latestInput = null
        }
    }

    fun convertToDecimal() = with(displayValue) {
        if (currentExpression.endsWith(SIGN_EQUALS)) clearAll()
        latestInput.orDefault(ZERO)
            .takeUnless { it.contains(DECIMAL_DOT) }
            ?.let {
                value = it + DECIMAL_DOT
                latestInput = value
            }
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
            if (currentExpression.endsWith(SIGN_EQUALS))
                currentExpression = String.EMPTY
            if (function != NEGATION) latestInput = null
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
