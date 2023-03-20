package pl.piasta.lincalc.ui.main.control

import javafx.scene.control.Button
import pl.piasta.lincalc.ui.main.Styles.Companion.circleButton
import tornadofx.*

open class CircleButton(text: String) : Button(text) {
    init {
        useMaxWidth = true
        useMaxHeight = true
        addClass(circleButton)
    }
}
