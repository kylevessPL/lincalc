package pl.piasta.lincalc.ui.main.control

import javafx.scene.Cursor.DEFAULT
import javafx.scene.control.TextField
import pl.piasta.lincalc.ui.main.Styles.Companion.digitalScreen
import tornadofx.*

class DigitalScreen : TextField() {
    init {
        isEditable = false
        cursor = DEFAULT
        selectedTextProperty().addListener { _, _, _ ->
            deselect()
        }
        addClass(digitalScreen)
    }
}
