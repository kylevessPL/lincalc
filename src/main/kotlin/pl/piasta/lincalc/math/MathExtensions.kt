package pl.piasta.lincalc.math

import ch.obermuhlner.math.big.DefaultBigDecimalMath.cos
import ch.obermuhlner.math.big.DefaultBigDecimalMath.createLocalMathContext
import ch.obermuhlner.math.big.DefaultBigDecimalMath.sin
import ch.obermuhlner.math.big.DefaultBigDecimalMath.sqrt
import java.math.BigDecimal

object MathExtensions {
    private const val PRECISION = 32

    fun BigDecimal.percentage(): BigDecimal = divide(BigDecimal(100))

    fun BigDecimal.sqrt(): BigDecimal = createLocalMathContext(PRECISION).use { sqrt(this) }

    fun BigDecimal.sin(): BigDecimal = createLocalMathContext(PRECISION).use { sin(this) }

    fun BigDecimal.cos(): BigDecimal = createLocalMathContext(PRECISION).use { cos(this) }
}
