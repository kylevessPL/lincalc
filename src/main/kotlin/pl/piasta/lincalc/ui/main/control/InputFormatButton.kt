package pl.piasta.lincalc.ui.main.control

import pl.piasta.lincalc.ui.main.Styles.Companion.inputFormatButton
import tornadofx.addClass

class InputFormatButton(text: String) : CircleButton(text) {
    init {
        addClass(inputFormatButton)
    }
}
