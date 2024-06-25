package ext

import com.github.ajalt.colormath.model.HSL
import kotlin.math.max
import kotlin.math.min

fun HSL.lighten(amount: Double): HSL = HSL(this.h, this.s, min(1.0, this.l + amount))

fun HSL.darken(amount: Double): HSL = HSL(this.h, this.s, max(0.0, this.l - amount))