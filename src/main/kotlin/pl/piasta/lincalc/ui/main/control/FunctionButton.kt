package pl.piasta.lincalc.ui.main.control

import pl.piasta.lincalc.ui.main.Styles.Companion.functionButton
import tornadofx.addClass

class FunctionButton(text: String) : CircleButton(text) {
    init {
        addClass(functionButton)
    }
}
