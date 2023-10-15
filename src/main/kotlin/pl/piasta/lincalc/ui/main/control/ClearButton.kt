package pl.piasta.lincalc.ui.main.control

import pl.piasta.lincalc.ui.main.Styles.Companion.clearButton
import tornadofx.addClass

class ClearButton(text: String) : CircleButton(text) {
    init {
        addClass(clearButton)
    }
}
