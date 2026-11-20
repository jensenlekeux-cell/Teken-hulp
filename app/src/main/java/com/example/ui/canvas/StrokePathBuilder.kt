package com.example.ui.canvas

import android.graphics.PathMeasure
import android.graphics.RectF
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.asAndroidPath
import androidx.compose.ui.graphics.asComposePath
import com.example.data.LessonStroke
import com.example.data.StrokeCommand

data class CanvasSquareBounds(
    val left: Float,
    val top: Float,
    val side: Float
) {
    fun mapX(nx: Float): Float = left + nx * side
    fun mapY(ny: Float): Float = top + ny * side
    fun mapSize(n: Float): Float = n * side
}

fun computeSquareBounds(canvasSize: Size, paddingFraction: Float = 0.04f): CanvasSquareBounds {
    val minDim = minOf(canvasSize.width, canvasSize.height)
    val pad = minDim * paddingFraction
    val side = (minDim - pad * 2f).coerceAtLeast(1f)
    val left = (canvasSize.width - side) / 2f
    val top = (canvasSize.height - side) / 2f
    return CanvasSquareBounds(left = left, top = top, side = side)
}

fun LessonStroke.buildComposePath(bounds: CanvasSquareBounds): Path {
    val path = Path()
    for (cmd in commands) {
        when (cmd) {
            is StrokeCommand.MoveTo -> path.moveTo(bounds.mapX(cmd.x), bounds.mapY(cmd.y))
            is StrokeCommand.LineTo -> path.lineTo(bounds.mapX(cmd.x), bounds.mapY(cmd.y))
            is StrokeCommand.QuadTo -> path.quadraticTo(
                bounds.mapX(cmd.cx),
                bounds.mapY(cmd.cy),
                bounds.mapX(cmd.x),
                bounds.mapY(cmd.y)
            )
            is StrokeCommand.CubicTo -> path.cubicTo(
                bounds.mapX(cmd.c1x),
                bounds.mapY(cmd.c1y),
                bounds.mapX(cmd.c2x),
                bounds.mapY(cmd.c2y),
                bounds.mapX(cmd.x),
                bounds.mapY(cmd.y)
            )
            is StrokeCommand.Circle -> {
                val cx = bounds.mapX(cmd.cx)
                val cy = bounds.mapY(cmd.cy)
                val r = bounds.mapSize(cmd.radius)
                path.addOval(Rect(cx - r, cy - r, cx + r, cy + r))
            }
            is StrokeCommand.Oval -> {
                val cx = bounds.mapX(cmd.cx)
                val cy = bounds.mapY(cmd.cy)
                val rx = bounds.mapSize(cmd.rx)
                val ry = bounds.mapSize(cmd.ry)
                path.addOval(Rect(cx - rx, cy - ry, cx + rx, cy + ry))
            }
            is StrokeCommand.Arc -> {
                val cx = bounds.mapX(cmd.cx)
                val cy = bounds.mapY(cmd.cy)
                val rx = bounds.mapSize(cmd.rx)
                val ry = bounds.mapSize(cmd.ry)
                path.addArc(
                    Rect(cx - rx, cy - ry, cx + rx, cy + ry),
                    startAngleDegrees = cmd.startAngle,
                    sweepAngleDegrees = cmd.sweepAngle
                )
            }
        }
    }
    return path
}

data class PartialPathResult(
    val path: Path,
    val tipPosition: Offset?
)

fun buildPartialPath(fullPath: Path, fraction: Float): PartialPathResult {
    val clamped = fraction.coerceIn(0f, 1f)
    if (clamped <= 0.001f) {
        return PartialPathResult(Path(), null)
    }
    if (clamped >= 0.999f) {
        return PartialPathResult(fullPath, null)
    }

    val androidSource = fullPath.asAndroidPath()
    val measure = PathMeasure(androidSource, false)

    // First pass: measure all contours
    val contourLengths = mutableListOf<Float>()
    var totalLength = 0f
    do {
        val len = measure.length
        contourLengths.add(len)
        totalLength += len
    } while (measure.nextContour())

    if (totalLength <= 0.01f) {
        return PartialPathResult(fullPath, null)
    }

    val targetDistance = totalLength * clamped
    val dstAndroidPath = android.graphics.Path()
    val measure2 = PathMeasure(androidSource, false)
    var accumulated = 0f
    var tipOffset: Offset? = null
    val pos = FloatArray(2)
    val tan = FloatArray(2)

    var index = 0
    do {
        val len = contourLengths.getOrElse(index) { 0f }
        if (len > 0f) {
            val remaining = targetDistance - accumulated
            if (remaining <= 0f) break
            if (remaining >= len) {
                measure2.getSegment(0f, len, dstAndroidPath, true)
                accumulated += len
            } else {
                measure2.getSegment(0f, remaining, dstAndroidPath, true)
                if (measure2.getPosTan(remaining, pos, tan)) {
                    tipOffset = Offset(pos[0], pos[1])
                }
                break
            }
        }
        index++
    } while (measure2.nextContour())

    return PartialPathResult(
        path = dstAndroidPath.asComposePath(),
        tipPosition = tipOffset
    )
}

@Suppress("unused")
fun LessonStroke.buildAndroidPathRect(bounds: CanvasSquareBounds): RectF {
    val rect = RectF()
    buildComposePath(bounds).asAndroidPath().computeBounds(rect, true)
    return rect
}
