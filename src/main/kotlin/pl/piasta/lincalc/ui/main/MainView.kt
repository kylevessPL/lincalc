package pl.piasta.lincalc.ui.main

import pl.piasta.lincalc.ui.main.view.KeypadView
import pl.piasta.lincalc.ui.main.view.ScreenView
import tornadofx.View
import tornadofx.vbox

internal class MainView : View("LinCalc") {

    private val screenView: ScreenView by inject()
    private val keypadView: KeypadView by inject()

    override val root = vbox {
        add(screenView)
        add(keypadView)
    }
}
