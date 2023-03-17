package pl.piasta.lincalc.ui.main.control

import pl.piasta.lincalc.ui.main.Styles.Companion.operatorButton
import tornadofx.addClass

class OperatorButton(text: String) : CircleButton(text) {
    init {
        addClass(operatorButton)
    }
}
