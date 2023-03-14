package pl.piasta.lincalc.ui.main

import javafx.beans.binding.Bindings.and
import javafx.beans.binding.Bindings.or
import javafx.scene.image.Image
import javafx.scene.layout.Pane
import javafx.scene.layout.Priority.ALWAYS
import kotlin.collections.Map.Entry
import tornadofx.View
import tornadofx.ViewModel
import tornadofx.action
import tornadofx.addClass
import tornadofx.button
import tornadofx.disableWhen
import tornadofx.find
import tornadofx.hbox
import tornadofx.hgrow
import tornadofx.onChange
import tornadofx.scrollpane
import tornadofx.splitpane
import tornadofx.vbox
import tornadofx.vgrow

internal class MainView : View("LinCalc") {

    override val root = vbox {
    }
}
