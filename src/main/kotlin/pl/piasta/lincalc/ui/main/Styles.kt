package pl.piasta.lincalc.ui.main

import javafx.geometry.Pos.CENTER_RIGHT
import javafx.scene.effect.BlurType.GAUSSIAN
import javafx.scene.effect.InnerShadow
import javafx.scene.paint.Color.BLACK
import javafx.scene.paint.Color.RED
import javafx.scene.paint.Color.WHITE
import javafx.scene.text.FontWeight.BOLD
import tornadofx.*

internal class Styles : Stylesheet() {
    companion object {
        val keypadPane by cssclass()
        val digitalScreen by cssclass()
        val circleButton by cssclass()
        val clearButton by cssclass()
        val trigonometricFunctionButton by cssclass()
        val operatorButton by cssclass()
        val digitInputButton by cssclass()
        val inputFormatButton by cssclass()
        val functionButton by cssclass()
    }

    init {
        root {
            prefWidth = 306.px
            prefHeight = 468.px
            backgroundColor += BLACK
        }
        keypadPane {
            padding = box(20.px)
            hgap = 20.px
            vgap = 20.px
        }
        digitalScreen {
            padding = box(20.px)
            prefHeight = 95.px
            alignment = CENTER_RIGHT
            backgroundColor += BLACK
            textFill = RED
        }
        circleButton {
            backgroundRadius += box(4.px)
            fontSize = 18.px
            fontWeight = BOLD
            pressed {
                effect = InnerShadow(GAUSSIAN, c(255, 255, 255, 0.5), 4.0, 0.0, 0.0, 3.0)
            }
        }
        clearButton {
            backgroundColor += c(51, 105, 30)
            textFill = WHITE
            pressed {
                effect = InnerShadow(GAUSSIAN, c(0, 0, 0, 0.5), 4.0, 0.0, 0.0, 3.0)
            }
        }
        trigonometricFunctionButton {
            backgroundColor += c(252, 214, 8)
        }
        operatorButton {
            backgroundColor += c(254, 148, 0)
            textFill = WHITE
            pressed {
                effect = InnerShadow(GAUSSIAN, c(0, 0, 0, 0.5), 4.0, 0.0, 0.0, 3.0)
            }
        }
        s(digitInputButton, inputFormatButton) {
            backgroundColor += c(51, 51, 51)
            textFill = WHITE
            pressed {
                effect = InnerShadow(GAUSSIAN, c(0, 0, 0, 0.5), 4.0, 0.0, 0.0, 3.0)
            }
        }
        functionButton {
            backgroundColor += c(166, 166, 166)
        }
    }
}
