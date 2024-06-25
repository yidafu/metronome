package icons

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun VectorPreview() {
    Image(AddCircle, null)
    Image(MinusCircle, null)
}

var _AddCircle: ImageVector? = null
val AddCircle: ImageVector
    get() {
        if (_AddCircle != null) {
            return _AddCircle!!
        }
        _AddCircle =
            ImageVector
                .Builder(
                    name = "PlusBorder",
                    defaultWidth = 200.dp,
                    defaultHeight = 200.dp,
                    viewportWidth = 1024f,
                    viewportHeight = 1024f,
                ).apply {
                    path(
                        fill = SolidColor(Color(0xFF8A8A8A)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero,
                    ) {
                        moveTo(480f, 64f)
                        arcTo(416.64f, 416.64f, 0f, isMoreThanHalf = false, isPositiveArc = false, 64f, 480f)
                        arcTo(416.64f, 416.64f, 0f, isMoreThanHalf = false, isPositiveArc = false, 480f, 896f)
                        arcTo(416.64f, 416.64f, 0f, isMoreThanHalf = false, isPositiveArc = false, 896f, 480f)
                        arcTo(416.64f, 416.64f, 0f, isMoreThanHalf = false, isPositiveArc = false, 480f, 64f)
                        close()
                        moveToRelative(0f, 64f)
                        curveTo(674.752f, 128f, 832f, 285.248f, 832f, 480f)
                        reflectiveCurveTo(674.752f, 832f, 480f, 832f)
                        arcTo(351.552f, 351.552f, 0f, isMoreThanHalf = false, isPositiveArc = true, 128f, 480f)
                        curveTo(128f, 285.248f, 285.248f, 128f, 480f, 128f)
                        close()
                        moveTo(448f, 256f)
                        verticalLineToRelative(192f)
                        horizontalLineTo(256f)
                        verticalLineToRelative(64f)
                        horizontalLineToRelative(192f)
                        verticalLineToRelative(192f)
                        horizontalLineToRelative(64f)
                        verticalLineTo(512f)
                        horizontalLineToRelative(192f)
                        verticalLineTo(448f)
                        horizontalLineTo(512f)
                        verticalLineTo(256f)
                        close()
                    }
                }.build()
        return _AddCircle!!
    }

private var _Minus: ImageVector? = null

val MinusCircle: ImageVector
    get() {
        if (_Minus != null) {
            return _Minus!!
        }
        _Minus =
            ImageVector
                .Builder(
                    name = "Minus",
                    defaultWidth = 200.dp,
                    defaultHeight = 200.dp,
                    viewportWidth = 1024f,
                    viewportHeight = 1024f,
                ).apply {
                    path(
                        fill = SolidColor(Color(0xFF000000)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero,
                    ) {
                        moveTo(896f, 512f)
                        curveToRelative(0f, 212.0747f, -171.9253f, 384f, -384f, 384f)
                        reflectiveCurveTo(128f, 724.074667f, 128f, 512f)
                        reflectiveCurveTo(299.925333f, 128f, 512f, 128f)
                        reflectiveCurveToRelative(384f, 171.925333f, 384f, 384f)
                        close()
                        moveTo(512f, 853.333333f)
                        curveToRelative(188.5227f, 0f, 341.3333f, -152.8107f, 341.3333f, -341.3333f)
                        reflectiveCurveTo(700.522667f, 170.666667f, 512f, 170.666667f)
                        reflectiveCurveTo(170.666667f, 323.477333f, 170.666667f, 512f)
                        reflectiveCurveToRelative(152.810667f, 341.333333f, 341.333333f, 341.333333f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFF000000)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero,
                    ) {
                        moveTo(277.333333f, 512f)
                        arcToRelative(21.333333f, 21.333333f, 0f, isMoreThanHalf = false, isPositiveArc = true, 21.333334f, -21.333333f)
                        horizontalLineToRelative(423.104f)
                        arcToRelative(21.333333f, 21.333333f, 0f, isMoreThanHalf = true, isPositiveArc = true, 0f, 42.666666f)
                        horizontalLineTo(298.666667f)
                        arcToRelative(21.333333f, 21.333333f, 0f, isMoreThanHalf = false, isPositiveArc = true, -21.333334f, -21.333333f)
                        close()
                    }
                }.build()
        return _Minus!!
    }




private var _Play: ImageVector? = null

val Play: ImageVector
    get() {
        if (_Play != null) {
            return _Play!!
        }
        _Play = ImageVector.Builder(
            name = "Play",
            defaultWidth = 200.dp,
            defaultHeight = 200.dp,
            viewportWidth = 1024f,
            viewportHeight = 1024f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF364F6B)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(906.56f, 421.44f)
                lineTo(214.4f, 44.48f)
                arcTo(102.08f, 102.08f, 0f, isMoreThanHalf = false, isPositiveArc = false, 64f, 135.04f)
                verticalLineToRelative(753.92f)
                arcToRelative(102.08f, 102.08f, 0f, isMoreThanHalf = false, isPositiveArc = false, 150.4f, 90.56f)
                lineToRelative(692.16f, -376.96f)
                arcToRelative(103.36f, 103.36f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0f, -181.12f)
                close()
            }
        }.build()
        return _Play!!
    }


private var _Pause: ImageVector? = null

val Pause: ImageVector
    get() {
        if (_Pause != null) {
            return _Pause!!
        }
        _Pause = ImageVector.Builder(
            name = "Pause",
            defaultWidth = 200.dp,
            defaultHeight = 200.dp,
            viewportWidth = 1024f,
            viewportHeight = 1024f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF364F6B)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(64f, 32f)
                moveToRelative(160f, 0f)
                lineToRelative(64f, 0f)
                quadToRelative(160f, 0f, 160f, 160f)
                lineToRelative(0f, 640f)
                quadToRelative(0f, 160f, -160f, 160f)
                lineToRelative(-64f, 0f)
                quadToRelative(-160f, 0f, -160f, -160f)
                lineToRelative(0f, -640f)
                quadToRelative(0f, -160f, 160f, -160f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF364F6B)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(576f, 32f)
                moveToRelative(160f, 0f)
                lineToRelative(64f, 0f)
                quadToRelative(160f, 0f, 160f, 160f)
                lineToRelative(0f, 640f)
                quadToRelative(0f, 160f, -160f, 160f)
                lineToRelative(-64f, 0f)
                quadToRelative(-160f, 0f, -160f, -160f)
                lineToRelative(0f, -640f)
                quadToRelative(0f, -160f, 160f, -160f)
                close()
            }
        }.build()
        return _Pause!!
    }


