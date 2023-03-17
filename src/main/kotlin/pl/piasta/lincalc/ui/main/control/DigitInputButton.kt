package pl.piasta.lincalc.ui.main.control

import pl.piasta.lincalc.ui.main.Styles.Companion.digitInputButton
import tornadofx.addClass

class DigitInputButton(text: String) : CircleButton(text) {
    init {
        addClass(digitInputButton)
    }
}
