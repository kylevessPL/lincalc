package pl.piasta.lincalc.ui.main.control

import pl.piasta.lincalc.ui.main.Styles.Companion.flatCircleButton
import tornadofx.*

open class FlatCircleButton(text: String) : CircleButton(text) {
    init {
        addClass(flatCircleButton)
    }
}
