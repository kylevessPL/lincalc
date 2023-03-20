package pl.piasta.lincalc.ui.main.fragment

import javafx.scene.layout.Priority.ALWAYS
import pl.piasta.lincalc.common.digitalScreen
import pl.piasta.lincalc.ui.main.MainViewModel
import tornadofx.*

internal class ScreenFragment : View("Screen Fragment") {

    private val vm: MainViewModel by inject()

    override val root = hbox {
        digitalScreen(vm.displayValue) {
            hgrow = ALWAYS
        }
    }
}
