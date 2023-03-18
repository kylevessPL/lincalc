package pl.piasta.lincalc.ui.main.view

import javafx.scene.layout.Priority.ALWAYS
import pl.piasta.lincalc.common.digitInputButton
import pl.piasta.lincalc.common.expressionFormatButton
import pl.piasta.lincalc.common.flatCircleButton
import pl.piasta.lincalc.common.operatorButton
import pl.piasta.lincalc.common.trigonometricFunctionButton
import pl.piasta.lincalc.ui.main.Styles.Companion.clearButton
import pl.piasta.lincalc.ui.main.Styles.Companion.keypadPane
import tornadofx.*

internal class KeypadView : View("Keypad Fragment") {

    override val root = gridpane {
        vgrow = ALWAYS
        (0..2).forEach {
            constraintsForColumn(it).hgrow = ALWAYS
        }
        (1..4).forEach {
            constraintsForRow(it).vgrow = ALWAYS
        }
        row {
            flatCircleButton {
                text = "C"
                addClass(clearButton)
            }
            trigonometricFunctionButton {
                text = "sin"
            }
            trigonometricFunctionButton {
                text = "cos"
            }
            trigonometricFunctionButton {
                text = "tan"
            }
        }
        row {
            expressionFormatButton {
                text = "⁺∕₋"
            }
            expressionFormatButton {
                text = "%"
            }
            expressionFormatButton {
                text = "√"
            }
            operatorButton {
                text = "÷"
            }
        }
        row {
            digitInputButton {
                text = "7"
            }
            digitInputButton {
                text = "8"
            }
            digitInputButton {
                text = "9"
            }
            operatorButton {
                text = "×"
            }
        }
        row {
            digitInputButton {
                text = "4"
            }
            digitInputButton {
                text = "5"
            }
            digitInputButton {
                text = "6"
            }
            operatorButton {
                text = "-"
            }
        }
        row {
            digitInputButton {
                text = "1"
            }
            digitInputButton {
                text = "2"
            }
            digitInputButton {
                text = "3"
            }
            operatorButton {
                text = "+"
            }
        }
        row {
            digitInputButton {
                text = "0"
            }
            digitInputButton {
                text = "."
            }
            digitInputButton {
                text = "⌫"
            }
            operatorButton {
                text = "="
            }
        }
        addClass(keypadPane)
    }
}
