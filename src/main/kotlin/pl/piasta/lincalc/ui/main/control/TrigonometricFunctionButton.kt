package pl.piasta.lincalc.ui.main.control

import pl.piasta.lincalc.ui.main.Styles.Companion.trigonometricFunctionButton
import tornadofx.addClass

class TrigonometricFunctionButton(text: String) : CircleButton(text) {
    init {
        addClass(trigonometricFunctionButton)
    }
}
