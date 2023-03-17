package pl.piasta.lincalc.ui.main.view

import javafx.scene.layout.Priority.ALWAYS
import pl.piasta.lincalc.common.digitalScreen
import tornadofx.View
import tornadofx.hbox
import tornadofx.hgrow

internal class ScreenView : View("Screen Fragment") {

    override val root = hbox {
        digitalScreen {
            hgrow = ALWAYS
            text = "0"
        }
    }
}
