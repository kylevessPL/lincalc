package pl.piasta.lincalc.ui.main.control

import pl.piasta.lincalc.ui.main.Styles.Companion.expressionFormatButton
import tornadofx.addClass

class ExpressionFormatButton(text: String) : CircleButton(text) {
    init {
        addClass(expressionFormatButton)
    }
}
