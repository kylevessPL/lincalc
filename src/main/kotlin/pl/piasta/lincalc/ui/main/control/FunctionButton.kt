package pl.piasta.lincalc.ui.main.control

import pl.piasta.lincalc.ui.main.Styles.Companion.functionButton
import tornadofx.*

class FunctionButton(text: String) : CircleButton(text) {
    init {
        addClass(functionButton)
    }
}
