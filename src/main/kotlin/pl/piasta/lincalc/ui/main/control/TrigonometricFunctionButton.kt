package pl.piasta.lincalc.ui.main.control

import pl.piasta.lincalc.ui.main.Styles.Companion.trigonometricFunctionButton
import tornadofx.*

class TrigonometricFunctionButton(text: String) : FlatCircleButton(text) {
    init {
        addClass(trigonometricFunctionButton)
    }
}
