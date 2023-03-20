package pl.piasta.lincalc.ui.main

import pl.piasta.lincalc.ui.main.fragment.KeypadFragment
import pl.piasta.lincalc.ui.main.fragment.ScreenFragment
import tornadofx.*

internal class MainView : View("LinCalc") {

    private val screenFragment: ScreenFragment by inject()
    private val keypadFragment: KeypadFragment by inject()

    override val root = vbox {
        add(screenFragment)
        add(keypadFragment)
    }
}
