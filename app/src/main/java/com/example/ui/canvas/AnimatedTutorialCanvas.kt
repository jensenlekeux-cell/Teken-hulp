package com.example.ui.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.example.data.DrawingLesson
import com.example.data.LessonStroke
import com.example.data.PaperGridStyle
import com.example.data.StrokeKind
import com.example.ui.theme.BlueprintGuide

@Composable
fun AnimatedTutorialCanvas(
    lesson: DrawingLesson,
    currentStepIndex: Int,
    stepAnimationProgress: Float,
    showConstructionLines: Boolean,
    gridStyle: PaperGridStyle,
    modifier: Modifier = Modifier,
    ghostMode: Boolean = false,
    ghostAlpha: Float = 0.30f,
    paperColor: Color = Color(0xFFFFFDF8)
) {
    val inkColor = if (ghostMode) {
        Color(0xFF2B2520).copy(alpha = ghostAlpha)
    } else {
        Color(0xFF231F1C)
    }
    val highlightColor = MaterialTheme.colorScheme.primary
    val constructionColor = BlueprintGuide.copy(alpha = if (ghostMode) ghostAlpha * 1.15f else 0.58f)
    val shadingColor = if (ghostMode) {
        Color(0xFF6B6259).copy(alpha = ghostAlpha * 0.85f)
    } else {
        Color(0xFF6B6259).copy(alpha = 0.72f)
    }

    Box(modifier = modifier) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            if (!ghostMode) {
                drawRect(color = paperColor)
                drawPaperTextureGrid(gridStyle = gridStyle)
            }

            val bounds = computeSquareBounds(size, paddingFraction = 0.05f)
            val clampedStep = currentStepIndex.coerceIn(0, lesson.steps.lastIndex)

            // 1. Draw previous completed steps
            for (sIdx in 0 until clampedStep) {
                val step = lesson.steps[sIdx]
                for (stroke in step.strokes) {
                    if (stroke.kind == StrokeKind.CONSTRUCTION && !showConstructionLines) continue
                    val path = stroke.buildComposePath(bounds)
                    drawLessonStroke(
                        path = path,
                        stroke = stroke,
                        isActiveStep = false,
                        inkColor = inkColor,
                        highlightColor = highlightColor,
                        constructionColor = constructionColor,
                        shadingColor = shadingColor
                    )
                }
            }

            // 2. Draw current step's strokes sequentially based on stepAnimationProgress (0f..1f)
            val activeStep = lesson.steps[clampedStep]
            val visibleStrokes = activeStep.strokes.filter {
                it.kind != StrokeKind.CONSTRUCTION || showConstructionLines
            }
            if (visibleStrokes.isNotEmpty()) {
                val perStrokeSpan = 1f / visibleStrokes.size
                var activeTip: Offset? = null

                visibleStrokes.forEachIndexed { index, stroke ->
                    val start = index * perStrokeSpan
                    val localProgress = ((stepAnimationProgress - start) / perStrokeSpan).coerceIn(0f, 1f)
                    if (localProgress > 0f) {
                        val fullPath = stroke.buildComposePath(bounds)
                        val partial = buildPartialPath(fullPath, localProgress)
                        drawLessonStroke(
                            path = partial.path,
                            stroke = stroke,
                            isActiveStep = !ghostMode,
                            inkColor = inkColor,
                            highlightColor = highlightColor,
                            constructionColor = constructionColor,
                            shadingColor = shadingColor
                        )
                        if (partial.tipPosition != null && localProgress < 1f) {
                            activeTip = partial.tipPosition
                        }
                    }
                }

                // 3. Draw animated pencil cursor at active stroke tip
                val tip = activeTip
                if (tip != null && !ghostMode) {
                    drawPencilCursor(tip = tip, accentColor = highlightColor)
                }
            }
        }
    }
}

@Composable
fun LessonThumbnailCanvas(
    lesson: DrawingLesson,
    modifier: Modifier = Modifier,
    inkColor: Color = Color(0xFF231F1C)
) {
    val accentColor = Color(lesson.accentHex)
    Canvas(modifier = modifier) {
        val bounds = computeSquareBounds(size, paddingFraction = 0.08f)
        for (step in lesson.steps) {
            for (stroke in step.strokes) {
                if (stroke.kind == StrokeKind.CONSTRUCTION) continue
                val path = stroke.buildComposePath(bounds)
                val strokeWidth = when (stroke.kind) {
                    StrokeKind.OUTLINE -> 2.4.dp.toPx() * stroke.widthScale
                    StrokeKind.DETAIL -> 1.8.dp.toPx() * stroke.widthScale
                    StrokeKind.SHADING -> 1.2.dp.toPx() * stroke.widthScale
                    StrokeKind.CONSTRUCTION -> 1.dp.toPx()
                }
                val color = when (stroke.kind) {
                    StrokeKind.OUTLINE -> inkColor
                    StrokeKind.DETAIL -> accentColor.copy(alpha = 0.9f)
                    StrokeKind.SHADING -> inkColor.copy(alpha = 0.45f)
                    StrokeKind.CONSTRUCTION -> Color.Transparent
                }
                drawPath(
                    path = path,
                    color = color,
                    style = Stroke(
                        width = strokeWidth,
                        cap = StrokeCap.Round,
                        join = StrokeJoin.Round
                    )
                )
            }
        }
    }
}

fun DrawScope.drawPaperTextureGrid(gridStyle: PaperGridStyle) {
    when (gridStyle) {
        PaperGridStyle.NONE -> Unit
        PaperGridStyle.DOTS -> {
            val spacing = 22.dp.toPx()
            val dotColor = Color(0xFFD6CEC2)
            var x = spacing
            while (x < size.width) {
                var y = spacing
                while (y < size.height) {
                    drawCircle(color = dotColor, radius = 1.2.dp.toPx(), center = Offset(x, y))
                    y += spacing
                }
                x += spacing
            }
        }
        PaperGridStyle.GRID -> {
            val spacing = 26.dp.toPx()
            val lineColor = Color(0xFFE7DFD3)
            var x = spacing
            while (x < size.width) {
                drawLine(
                    color = lineColor,
                    start = Offset(x, 0f),
                    end = Offset(x, size.height),
                    strokeWidth = 1.dp.toPx()
                )
                x += spacing
            }
            var y = spacing
            while (y < size.height) {
                drawLine(
                    color = lineColor,
                    start = Offset(0f, y),
                    end = Offset(size.width, y),
                    strokeWidth = 1.dp.toPx()
                )
                y += spacing
            }
        }
    }
}

private fun DrawScope.drawLessonStroke(
    path: Path,
    stroke: LessonStroke,
    isActiveStep: Boolean,
    inkColor: Color,
    highlightColor: Color,
    constructionColor: Color,
    shadingColor: Color
) {
    val baseWidth = when (stroke.kind) {
        StrokeKind.CONSTRUCTION -> 1.6.dp.toPx()
        StrokeKind.OUTLINE -> 3.4.dp.toPx()
        StrokeKind.DETAIL -> 2.4.dp.toPx()
        StrokeKind.SHADING -> 1.8.dp.toPx()
    } * stroke.widthScale

    val color = when {
        stroke.kind == StrokeKind.CONSTRUCTION -> constructionColor
        isActiveStep -> highlightColor
        stroke.kind == StrokeKind.SHADING -> shadingColor
        else -> inkColor
    }

    val effect = if (stroke.kind == StrokeKind.CONSTRUCTION) {
        PathEffect.dashPathEffect(floatArrayOf(12f, 10f), 0f)
    } else {
        null
    }

    drawPath(
        path = path,
        color = color,
        style = Stroke(
            width = baseWidth,
            cap = StrokeCap.Round,
            join = StrokeJoin.Round,
            pathEffect = effect
        )
    )
}

private fun DrawScope.drawPencilCursor(tip: Offset, accentColor: Color) {
    // Soft glowing halo around active pencil point
    drawCircle(
        color = accentColor.copy(alpha = 0.22f),
        radius = 13.dp.toPx(),
        center = tip
    )
    drawCircle(
        color = accentColor,
        radius = 4.dp.toPx(),
        center = tip
    )

    // Stylized angled wooden pencil nib pointing right at `tip`
    val bodyStart = Offset(tip.x + 6.dp.toPx(), tip.y - 6.dp.toPx())
    val bodyEnd = Offset(tip.x + 26.dp.toPx(), tip.y - 26.dp.toPx())
    drawLine(
        color = Color(0xFF231F1C),
        start = tip,
        end = bodyStart,
        strokeWidth = 3.dp.toPx(),
        cap = StrokeCap.Round
    )
    drawLine(
        color = Color(0xFFE5A93C),
        start = bodyStart,
        end = bodyEnd,
        strokeWidth = 7.5.dp.toPx(),
        cap = StrokeCap.Round
    )
    drawLine(
        color = accentColor,
        start = bodyEnd,
        end = Offset(bodyEnd.x + 3.dp.toPx(), bodyEnd.y - 3.dp.toPx()),
        strokeWidth = 7.5.dp.toPx(),
        cap = StrokeCap.Round
    )
}
