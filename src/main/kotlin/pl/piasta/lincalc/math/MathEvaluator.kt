package pl.piasta.lincalc.math

import java.math.BigDecimal
import javax.script.ScriptEngineManager

object MathEvaluator {

    private val scriptEngine = ScriptEngineManager().getEngineByName("JavaScript")

    fun evaluateExpression(expression: String) = runCatching {
        println(expression)
        val result = scriptEngine.eval(expression).toString()
        BigDecimal(result)
    }.getOrNull()
}
