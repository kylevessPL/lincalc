package pl.piasta.lincalc.ui.main.control

import javafx.beans.value.ChangeListener
import javafx.scene.Cursor.HAND
import javafx.scene.control.TextField
import javafx.scene.text.Font
import javafx.scene.text.Text
import pl.piasta.lincalc.common.Constants.DIGITAL_FONT
import pl.piasta.lincalc.common.Constants.FONT_ASSETS
import pl.piasta.lincalc.common.EMPTY
import pl.piasta.lincalc.common.ZERO
import pl.piasta.lincalc.common.toFont
import pl.piasta.lincalc.ui.main.Styles.Companion.digitalScreen
import tornadofx.addClass
import tornadofx.horizontal
import tornadofx.runAsync
import tornadofx.ui

class DigitalScreen : TextField() {
    private companion object {
        const val FONT_SIZE_MIN = 18.0
        val digitalFont = "$FONT_ASSETS/$DIGITAL_FONT".toFont(64.0)
    }

    init {
        isEditable = false
        font = digitalFont
        cursor = HAND
        selectedTextProperty().addListener { _, _, _ ->
            deselect()
        }
        textProperty().addListener { _, oldValue, newValue ->
            oldValue.takeUnless { it == String.EMPTY }?.let {
                runAsync(true) {
                    calculateFont(newValue)
                } ui {
                    font = calculateFont(newValue)
                    positionCaret(text.length)
                }
            }
        }
        ChangeListener<Number> { _, oldValue, _ ->
            oldValue.takeUnless { it == Double.ZERO }?.let {
                runAsync(true) {
                    calculateFont(text)
                } ui {
                    font = it
                    positionCaret(text.length)
                }
            }
        }.run {
            widthProperty().addListener(this)
            heightProperty().addListener(this)
        }
        addClass(digitalScreen)
    }

    private fun calculateFont(newValue: String?): Font? {
        val tmpText = Text(newValue)
        tmpText.font = digitalFont
        val textWidth = tmpText.layoutBounds.width
        val maxWidth = width - 2 * padding.horizontal - 2
        return if (textWidth > maxWidth) {
            val calculatedSize = digitalFont!!.size * maxWidth / textWidth
            Font.font(digitalFont.family, calculatedSize.coerceAtLeast(FONT_SIZE_MIN))
        } else digitalFont
    }
}
