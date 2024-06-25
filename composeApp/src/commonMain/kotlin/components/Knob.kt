package components

import LocalRhythmViewModel
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.github.ajalt.colormath.extensions.android.composecolor.toColormathColor
import com.github.ajalt.colormath.extensions.android.composecolor.toComposeColor
import ext.darken
import icons.Pause
import icons.Play
import kotlin.math.PI
import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

@Composable
fun Dp.dpToPx() = with(LocalDensity.current) { this@dpToPx.toPx() }

fun DrawScope.drawLight(
    degree: Float,
    outerRadius: Float,
    innerRadius: Float,
    offset: Offset,
    strokeWidth: Int = 2,
) {
    val outer = outerRadius.dp.toPx()
    val inner = innerRadius.dp.toPx()
    val a = sin(degree)
    val b = cos(degree)
    val start = Offset((a * outer), (b * outer)) + offset
    val end = Offset((a * inner), (b * inner)) + offset
    drawLine(Color.Red, start, end, strokeWidth.dp.toPx(), StrokeCap.Round)
}

/**
 * 通过法向量判断旋转方向
 */
fun judgeDirection(
    p1: Offset,
    p2: Offset,
): Int {
    // x1y2 - x2y1
    return if ((p1.x * p2.y - p2.x * p1.y) > 0) -1 else 1
}

@Composable
fun Sunlight(
    modifier: Modifier,
    width: Int,
    ringGap: Int,
) {
    val outerRadius = width / 2.0f - 8f
    val innerRadius = (width / 2.0f) - ringGap + 8f
    val offsetX = width / 2.0f
    val indicatorDegree = remember { mutableStateOf<Double>(PI) }
    val circleCenter = Offset(offsetX.dp.dpToPx(), offsetX.dp.dpToPx())

    val vm = LocalRhythmViewModel.current

    Canvas(
        modifier =
            modifier.size(width.dp).pointerInput(Unit) {
                awaitEachGesture {
                    val down = awaitFirstDown()
                    var lastOffset: Offset? = null
                    do {
                        val event = awaitPointerEvent()
                        event.changes.forEach {
                            when (event.type) {
                                PointerEventType.Move -> {
                                    // offset to degree
                                    val offset = it.position - circleCenter

                                    // Cos (θ) = (A·B) / (|A|·|B|)
                                    lastOffset?.let { d ->
                                        val productValue = (d.x * offset.x) + (d.y * offset.y); // 向量的乘积
                                        val aMod = sqrt(d.x * d.x + d.y * d.y); // 向量a的模
                                        val bMod =
                                            sqrt(offset.x * offset.x + offset.y * offset.y); // 向量b的模
                                        var cosValue = productValue / (aMod * bMod); // 余弦公式
                                        if (cosValue < -1 && cosValue > -2) {
                                            cosValue = -1f
                                        } else if (cosValue > 1 && cosValue < 2) {
                                            cosValue = 1f
                                        }
                                        val degree = acos(cosValue.toDouble())
                                        val direction = judgeDirection(d, offset)
                                        vm.updateBpmByDegree((degree * direction) / PI * 360f)
                                        indicatorDegree.value += degree * direction
                                    }
                                    lastOffset = offset
                                }

                                PointerEventType.Release -> {
                                }
                            }
                            it.consume()
                        }
                    } while (event.changes.any { it.pressed })
                }
            },
    ) {
        val oneLightDegree = (PI * 2) / 60
        0.rangeTo(59).forEach { degree ->
            drawLight(
                oneLightDegree.toFloat() * degree,
                outerRadius,
                innerRadius,
                circleCenter,
            )
        }
        val indicatorRadius = innerRadius - 8f * 2f
        drawLight(
            indicatorDegree.value.toFloat(),
            indicatorRadius,
            indicatorRadius - 24f,
            circleCenter,
            3,
        )
    }
}

@Composable
fun Knob() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Box(
            Modifier
                .size(200.dp)
                .background(MaterialTheme.colorScheme.surface, shape = CircleShape),
        ) {
            val circleColor: Color = MaterialTheme.colorScheme.surfaceContainerLowest
            val shadowColor =
                circleColor
                    .toColormathColor()
                    .toHSL()
                    .darken(0.3)
                    .toComposeColor()
            val innerCircleBgColor =
                circleColor
                    .toColormathColor()
                    .toHSL()
                    .darken(0.05)
                    .toComposeColor()
            Box(
                Modifier
                    .size(140.dp)
                    .shadow(5.dp, CircleShape, spotColor = shadowColor)
                    .background(
                        MaterialTheme.colorScheme.surfaceContainerLowest,
                        shape = CircleShape,
                    ).align(Alignment.Center),
            )

            Sunlight(Modifier.align(Alignment.Center), 200, 30)

            val vm = LocalRhythmViewModel.current
            Box(
                Modifier
                    .size(60.dp)
                    .shadow(5.dp, CircleShape, spotColor = shadowColor)
                    .background(
                        innerCircleBgColor,
                        shape = CircleShape,
                    ).align(Alignment.Center)
                    .clickable {
                        vm.toggle()
                    },
            ) {
                Box(
                    Modifier
                        .size(50.dp)
                        .shadow(5.dp, CircleShape, spotColor = Color.Red)
                        .background(
                            innerCircleBgColor,
                            shape = CircleShape,
                        ).align(Alignment.Center),
                )
                val status = vm.status.collectAsState()
                val icon = if (status.value) Pause else Play
                Icon(
                    icon,
                    "play",
                    Modifier.align(Alignment.Center).size(30.dp).offset(x = 3.dp),
                    Color.Red,
                )
            }
        }
    }
}
