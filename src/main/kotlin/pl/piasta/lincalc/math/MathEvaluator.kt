package pl.piasta.lincalc.math

import java.math.BigDecimal
import javax.script.ScriptEngineManager

object MathEvaluator {

    private val scriptEngine = ScriptEngineManager().getEngineByName("JavaScript")

    fun evaluateExpression(expression: String) = runCatching {
        val result = scriptEngine.eval(expression) as String
        BigDecimal(result)
    }.getOrNull()
}
