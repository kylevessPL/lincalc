package pl.piasta.lincalc.ui.main

import javafx.geometry.Pos.CENTER_RIGHT
import javafx.scene.paint.Color.BLACK
import javafx.scene.paint.Color.RED
import javafx.scene.paint.Color.WHITE
import javafx.scene.text.FontWeight.BOLD
import pl.piasta.lincalc.common.Constants.FONT_ASSETS
import tornadofx.Stylesheet
import tornadofx.box
import tornadofx.c
import tornadofx.cssclass
import tornadofx.em
import tornadofx.loadFont
import tornadofx.px

internal class Styles : Stylesheet() {
    companion object {
        val digitalFont = loadFont("$FONT_ASSETS/digital-7.ttf", 48.0)
        val keypadPane by cssclass()
        val digitalScreen by cssclass()
        val circleButton by cssclass()
        val trigonometricFunctionButton by cssclass()
        val operatorButton by cssclass()
        val digitInputButton by cssclass()
        val expressionFormatButton by cssclass()
    }

    init {
        root {
            prefWidth = 345.px
            prefHeight = 574.px
            backgroundColor += BLACK
        }
        keypadPane {
            padding = box(20.px)
            hgap = 20.px
            vgap = 20.px
        }
        digitalScreen {
            alignment = CENTER_RIGHT
            backgroundColor += BLACK
            textFill = RED
            digitalFont?.let {
                font = it
            }
        }
        circleButton {
            prefWidth = 60.px
            prefHeight = 60.px
            backgroundRadius += box(5.em)
            fontSize = 18.px
            fontWeight = BOLD
        }
        trigonometricFunctionButton {
            prefHeight = 30.px
            backgroundColor += c(252, 214, 8)
        }
        operatorButton {
            backgroundColor += c(254, 148, 0)
            textFill = WHITE
        }
        digitInputButton {
            backgroundColor += c(51, 51, 51)
            textFill = WHITE
        }
        expressionFormatButton {
            backgroundColor += c(166, 166, 166)
        }
    }
}
