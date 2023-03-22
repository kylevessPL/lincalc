package pl.piasta.lincalc.common

import java.lang.invoke.MethodHandles
import java.math.BigDecimal
import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.StringExpression
import javafx.beans.property.SimpleStringProperty
import javafx.beans.value.ObservableValue
import javafx.event.EventTarget
import javafx.scene.Node
import javafx.scene.text.Font
import pl.piasta.lincalc.common.Constants.DECIMAL_DOT
import pl.piasta.lincalc.common.Constants.ZERO
import pl.piasta.lincalc.ui.main.control.ClearButton
import pl.piasta.lincalc.ui.main.control.DigitInputButton
import pl.piasta.lincalc.ui.main.control.DigitalScreen
import pl.piasta.lincalc.ui.main.control.FunctionButton
import pl.piasta.lincalc.ui.main.control.InputFormatButton
import pl.piasta.lincalc.ui.main.control.OperatorButton
import pl.piasta.lincalc.ui.main.control.TrigonometricFunctionButton
import tornadofx.*

val Double.Companion.ZERO: Double
    get() = 0.0

val String.Companion.EMPTY: String
    get() = ""

val String.Companion.NaN: String
    get() = "NaN"

fun String.isNaN() = this == String.NaN

fun String?.orDefault(value: String) = if (isNullOrEmpty()) value else this

fun String.stripTrailingZeros() = takeIf { contains(DECIMAL_DOT) and endsWith(ZERO) }?.let {
    val stripped = dropLastWhile { it == '0' }
    if (stripped.endsWith(DECIMAL_DOT))
        stripped.dropLast(1)
    else stripped
} ?: this

inline fun String.takeLastWhileInclusive(predicate: (Char) -> Boolean): String {
    for (index in lastIndex downTo 0) {
        if (!predicate(this[index])) {
            return substring(index)
        }
    }
    return this
}

fun String.toBigDecimal(): BigDecimal {
    val value = if (isNaN()) ZERO else this.takeIf { endsWith(DECIMAL_DOT) }
        ?.dropLast(1)
        ?: this
    return BigDecimal(value)
}

fun String.toFont(size: Number) = MethodHandles.lookup()
    .lookupClass()
    .getResourceAsStream(this)?.use { Font.loadFont(it, size.toDouble()) }

fun StringExpression.isNaN(): BooleanBinding = Bindings.equal(String.NaN, this)

fun SimpleStringProperty.valueOrDefault(default: String) = value.takeIf { it != String.NaN } ?: default

fun EventTarget.digitalScreen(value: String? = null, op: DigitalScreen.() -> Unit = {}) =
    DigitalScreen().attachTo(this, op) {
        if (value != null) it.text = value
    }

fun EventTarget.digitalScreen(property: ObservableValue<String>, op: DigitalScreen.() -> Unit = {}) =
    digitalScreen().apply {
        bind(property)
        op(this)
    }

fun EventTarget.clearButton(
    text: String = "",
    graphic: Node? = null,
    op: ClearButton.() -> Unit = {}
) = ClearButton(text).attachTo(this, op) {
    if (graphic != null) it.graphic = graphic
}

fun EventTarget.trigonometricFunctionButton(
    text: String = "",
    graphic: Node? = null,
    op: TrigonometricFunctionButton.() -> Unit = {}
) = TrigonometricFunctionButton(text).attachTo(this, op) {
    if (graphic != null) it.graphic = graphic
}

fun EventTarget.digitInputButton(text: String = "", graphic: Node? = null, op: DigitInputButton.() -> Unit = {}) =
    DigitInputButton(text).attachTo(this, op) {
        if (graphic != null) it.graphic = graphic
    }

fun EventTarget.inputFormatButton(text: String = "", graphic: Node? = null, op: InputFormatButton.() -> Unit = {}) =
    InputFormatButton(text).attachTo(this, op) {
        if (graphic != null) it.graphic = graphic
    }

fun EventTarget.functionButton(
    text: String = "",
    graphic: Node? = null,
    op: FunctionButton.() -> Unit = {}
) = FunctionButton(text).attachTo(this, op) {
    if (graphic != null) it.graphic = graphic
}

fun EventTarget.operatorButton(text: String = "", graphic: Node? = null, op: OperatorButton.() -> Unit = {}) =
    OperatorButton(text).attachTo(this, op) {
        if (graphic != null) it.graphic = graphic
    }
