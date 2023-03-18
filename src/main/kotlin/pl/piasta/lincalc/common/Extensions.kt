package pl.piasta.lincalc.common

import javafx.event.EventTarget
import javafx.scene.Node
import pl.piasta.lincalc.ui.main.control.DigitInputButton
import pl.piasta.lincalc.ui.main.control.DigitalScreen
import pl.piasta.lincalc.ui.main.control.ExpressionFormatButton
import pl.piasta.lincalc.ui.main.control.FlatCircleButton
import pl.piasta.lincalc.ui.main.control.OperatorButton
import pl.piasta.lincalc.ui.main.control.TrigonometricFunctionButton
import tornadofx.*

fun EventTarget.digitalScreen(value: String? = null, op: DigitalScreen.() -> Unit = {}) =
    DigitalScreen().attachTo(this, op) {
        if (value != null) it.text = value
    }

fun EventTarget.flatCircleButton(
    text: String = "",
    graphic: Node? = null,
    op: FlatCircleButton.() -> Unit = {}
) = FlatCircleButton(text).attachTo(this, op) {
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

fun EventTarget.expressionFormatButton(
    text: String = "",
    graphic: Node? = null,
    op: ExpressionFormatButton.() -> Unit = {}
) = ExpressionFormatButton(text).attachTo(this, op) {
    if (graphic != null) it.graphic = graphic
}

fun EventTarget.operatorButton(text: String = "", graphic: Node? = null, op: OperatorButton.() -> Unit = {}) =
    OperatorButton(text).attachTo(this, op) {
        if (graphic != null) it.graphic = graphic
    }
