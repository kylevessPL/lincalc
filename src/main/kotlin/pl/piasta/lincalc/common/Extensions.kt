package pl.piasta.lincalc.common

import java.util.concurrent.CountDownLatch
import javafx.beans.binding.Bindings.createStringBinding
import javafx.beans.binding.IntegerExpression
import javafx.beans.binding.StringBinding
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.seconds
import tornadofx.FXTask
import tornadofx.runLater

fun Image.asView() = ImageView(this)
