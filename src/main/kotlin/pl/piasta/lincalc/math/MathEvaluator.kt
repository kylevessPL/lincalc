package pl.piasta.lincalc.math

import java.math.BigDecimal
import javax.script.ScriptEngineManager
import pl.piasta.lincalc.common.Constants.PRECISION

object MathEvaluator {

    private val scriptEngine = ScriptEngineManager().getEngineByName("JavaScript")

    fun evaluateExpression(expression: String) = runCatching {
        val evalScript = createEvalScript(expression)
        val result = scriptEngine.eval(evalScript).toString()
        BigDecimal(result)
    }.getOrNull()

    private fun createEvalScript(expression: String) = "parseFloat(($expression).toFixed($PRECISION))"
}
