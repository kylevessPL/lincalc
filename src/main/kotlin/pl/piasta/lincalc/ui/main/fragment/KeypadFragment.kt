package pl.piasta.lincalc.ui.main.fragment

import javafx.scene.layout.Priority.ALWAYS
import pl.piasta.lincalc.common.clearButton
import pl.piasta.lincalc.common.digitInputButton
import pl.piasta.lincalc.common.functionButton
import pl.piasta.lincalc.common.inputFormatButton
import pl.piasta.lincalc.common.isNaN
import pl.piasta.lincalc.common.operatorButton
import pl.piasta.lincalc.common.trigonometricFunctionButton
import pl.piasta.lincalc.math.MathFunction.COSINE
import pl.piasta.lincalc.math.MathFunction.NEGATION
import pl.piasta.lincalc.math.MathFunction.PERCENTAGE
import pl.piasta.lincalc.math.MathFunction.SINE
import pl.piasta.lincalc.math.MathFunction.SQUARE_ROOT
import pl.piasta.lincalc.math.MathOperator.ADD
import pl.piasta.lincalc.math.MathOperator.DIVIDE
import pl.piasta.lincalc.math.MathOperator.MULTIPLY
import pl.piasta.lincalc.math.MathOperator.SUBTRACT
import pl.piasta.lincalc.ui.main.MainViewModel
import pl.piasta.lincalc.ui.main.Styles.Companion.keypadPane
import pl.piasta.lincalc.ui.main.control.ClearButton
import pl.piasta.lincalc.ui.main.control.DigitInputButton
import tornadofx.View
import tornadofx.action
import tornadofx.addClass
import tornadofx.constraintsForColumn
import tornadofx.constraintsForRow
import tornadofx.disableWhen
import tornadofx.gridpane
import tornadofx.row
import tornadofx.vgrow

internal class KeypadFragment : View("Keypad Fragment") {

    private val vm: MainViewModel by inject()

    override val root = gridpane {
        vgrow = ALWAYS
        row {
            clearButton("CE").action {
                vm.clear()
            }
            clearButton("C").action {
                vm.clearAll()
            }
            trigonometricFunctionButton("sin").action {
                vm.convertByFunction(SINE)
            }
            trigonometricFunctionButton("cos").action {
                vm.convertByFunction(COSINE)
            }
        }
        row {
            functionButton("⁺∕₋").action {
                vm.convertByFunction(NEGATION)
            }
            functionButton("%").action {
                vm.convertByFunction(PERCENTAGE)
            }
            functionButton("√").action {
                vm.convertByFunction(SQUARE_ROOT)
            }
            operatorButton("÷").action {
                vm.doMathOperation(DIVIDE)
            }
        }
        row {
            digitInputButton("7")
            digitInputButton("8")
            digitInputButton("9")
            operatorButton("×").action {
                vm.doMathOperation(MULTIPLY)
            }
        }
        row {
            digitInputButton("4")
            digitInputButton("5")
            digitInputButton("6")
            operatorButton("-").action {
                vm.doMathOperation(SUBTRACT)
            }
        }
        row {
            digitInputButton("1")
            digitInputButton("2")
            digitInputButton("3")
            operatorButton("+").action {
                vm.doMathOperation(ADD)
            }
        }
        row {
            digitInputButton("0")
            inputFormatButton(".").action {
                vm.convertToDecimal()
            }
            inputFormatButton("⌫").action {
                vm.undoInput()
            }
            operatorButton("=").action {
                vm.evaluate()
            }
        }
        (0..3).forEach {
            constraintsForColumn(it).apply {
                hgrow = ALWAYS
                percentWidth = 25.0
            }
        }
        (0..5).forEach {
            constraintsForRow(it).vgrow = ALWAYS
        }
        children.filterIsInstance<DigitInputButton>().forEach {
            it.action {
                vm.doInput(it.text)
            }
        }
        children.filterNot { it is DigitInputButton || it is ClearButton }.forEach {
            it.disableWhen(vm.displayValue.isNaN())
        }
        addClass(keypadPane)
    }
}
