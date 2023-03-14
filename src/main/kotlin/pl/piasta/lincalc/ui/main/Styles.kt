package pl.piasta.lincalc.ui.main

import javafx.geometry.Pos.BASELINE_RIGHT
import javafx.scene.control.ScrollPane.ScrollBarPolicy.NEVER
import tornadofx.Stylesheet
import tornadofx.box
import tornadofx.cssclass
import tornadofx.multi
import tornadofx.percent
import tornadofx.px

internal class Styles : Stylesheet() {
    companion object;

    init {
        root {
            prefWidth = 950.px
            prefHeight = 600.px
        }
    }
}
