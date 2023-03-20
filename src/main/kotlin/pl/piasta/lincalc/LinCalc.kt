package pl.piasta.lincalc

import javafx.scene.image.Image
import javafx.stage.Stage
import pl.piasta.lincalc.common.Constants.IMAGE_ASSETS
import pl.piasta.lincalc.ui.main.MainView
import pl.piasta.lincalc.ui.main.Styles
import tornadofx.*

class LinCalc : App(MainView::class, Styles::class) {
    override fun start(stage: Stage) {
        setStageIcon(Image("$IMAGE_ASSETS/favicon.png"))
        with(stage) {
            minWidth = 321.0
            minHeight = 508.0
            super.start(this)
        }
    }
}

fun main() = launch<LinCalc>()
