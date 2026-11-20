package com.example.ui.canvas

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas as AndroidCanvas
import android.graphics.Paint
import android.graphics.Path as AndroidPath
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.core.content.FileProvider
import com.example.R
import com.example.data.BrushTool
import com.example.data.PaperGridStyle
import com.example.data.UserStroke
import com.example.data.UserStrokePoint
import java.io.File
import java.io.FileOutputStream

val StudioBrushColors: List<Pair<String, Long>> = listOf(
    "Zwart" to 0xFF1E1A16,
    "Bruin" to 0xFF795548,
    "Rood" to 0xFFE53935,
    "Oranje" to 0xFFD0552B,
    "Geel" to 0xFFF2B705,
    "Groen" to 0xFF43A047,
    "Blauw" to 0xFF1E88E5,
    "Paars" to 0xFF8E24AA
)

@Composable
fun InteractiveSketchCanvas(
    strokes: List<UserStroke>,
    activeTool: BrushTool,
    activeColorArgb: Long,
    activeWidthDp: Float,
    gridStyle: PaperGridStyle,
    onAddStroke: (UserStroke) -> Unit,
    modifier: Modifier = Modifier,
    paperColor: Color = Color(0xFFFFFDF8),
    underlayContent: (@Composable () -> Unit)? = null
) {
    var activePoints by remember { mutableStateOf<List<UserStrokePoint>>(emptyList()) }
    val currentTool by rememberUpdatedState(activeTool)
    val currentColor by rememberUpdatedState(activeColorArgb)
    val currentWidth by rememberUpdatedState(activeWidthDp)
    val currentOnAddStroke by rememberUpdatedState(onAddStroke)

    Box(modifier = modifier) {
        // Paper base + grid
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawRect(color = paperColor)
            drawPaperTextureGrid(gridStyle = gridStyle)
        }

        // Optional ghost tutorial underlay
        underlayContent?.invoke()

        // Interactive user ink canvas
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectDragGestures(
                        onDragStart = { offset ->
                            val w = size.width.coerceAtLeast(1).toFloat()
                            val h = size.height.coerceAtLeast(1).toFloat()
                            activePoints = listOf(
                                UserStrokePoint(
                                    x = (offset.x / w).coerceIn(0f, 1f),
                                    y = (offset.y / h).coerceIn(0f, 1f)
                                )
                            )
                        },
                        onDrag = { change, _ ->
                            change.consume()
                            val w = size.width.coerceAtLeast(1).toFloat()
                            val h = size.height.coerceAtLeast(1).toFloat()
                            val pt = UserStrokePoint(
                                x = (change.position.x / w).coerceIn(0f, 1f),
                                y = (change.position.y / h).coerceIn(0f, 1f)
                            )
                            val last = activePoints.lastOrNull()
                            if (last == null ||
                                kotlin.math.abs(last.x - pt.x) > 0.0015f ||
                                kotlin.math.abs(last.y - pt.y) > 0.0015f
                            ) {
                                activePoints = activePoints + pt
                            }
                        },
                        onDragEnd = {
                            if (activePoints.isNotEmpty()) {
                                currentOnAddStroke(
                                    UserStroke(
                                        points = activePoints,
                                        colorArgb = if (currentTool == BrushTool.ERASER) {
                                            0xFFFFFDF8
                                        } else {
                                            currentColor
                                        },
                                        strokeWidthDp = if (currentTool == BrushTool.ERASER) {
                                            currentWidth * 2.6f
                                        } else if (currentTool == BrushTool.MARKER) {
                                            currentWidth * 2.1f
                                        } else {
                                            currentWidth
                                        },
                                        tool = currentTool
                                    )
                                )
                            }
                            activePoints = emptyList()
                        },
                        onDragCancel = {
                            activePoints = emptyList()
                        }
                    )
                }
        ) {
            val w = size.width
            val h = size.height

            fun drawUserStroke(
                points: List<UserStrokePoint>,
                tool: BrushTool,
                colorArgb: Long,
                widthDp: Float
            ) {
                if (points.isEmpty()) return
                val color = when (tool) {
                    BrushTool.ERASER -> paperColor
                    BrushTool.MARKER -> Color(colorArgb).copy(alpha = 0.38f)
                    BrushTool.PENCIL -> Color(colorArgb).copy(alpha = 0.80f)
                    BrushTool.FINELINER -> Color(colorArgb)
                }
                val strokePx = widthDp.dp.toPx()

                if (points.size == 1) {
                    drawCircle(
                        color = color,
                        radius = strokePx / 2f,
                        center = Offset(points[0].x * w, points[0].y * h)
                    )
                    return
                }

                val path = Path().apply {
                    moveTo(points[0].x * w, points[0].y * h)
                    for (i in 1 until points.size) {
                        val prev = points[i - 1]
                        val curr = points[i]
                        val midX = ((prev.x + curr.x) / 2f) * w
                        val midY = ((prev.y + curr.y) / 2f) * h
                        quadraticTo(prev.x * w, prev.y * h, midX, midY)
                    }
                    val last = points.last()
                    lineTo(last.x * w, last.y * h)
                }

                drawPath(
                    path = path,
                    color = color,
                    style = Stroke(
                        width = strokePx,
                        cap = StrokeCap.Round,
                        join = StrokeJoin.Round
                    )
                )
            }

            for (s in strokes) {
                drawUserStroke(s.points, s.tool, s.colorArgb, s.strokeWidthDp)
            }

            if (activePoints.isNotEmpty()) {
                val width = when (activeTool) {
                    BrushTool.ERASER -> activeWidthDp * 2.6f
                    BrushTool.MARKER -> activeWidthDp * 2.1f
                    else -> activeWidthDp
                }
                drawUserStroke(activePoints, activeTool, activeColorArgb, width)
            }
        }
    }
}

fun shareDrawingAsPng(
    context: Context,
    strokes: List<UserStroke>,
    title: String
) {
    val sizePx = 1200
    val bitmap = Bitmap.createBitmap(sizePx, sizePx, Bitmap.Config.ARGB_8888)
    val canvas = AndroidCanvas(bitmap)
    canvas.drawColor(android.graphics.Color.parseColor("#FFFDF8"))

    val density = context.resources.displayMetrics.density
    val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeCap = Paint.Cap.ROUND
        strokeJoin = Paint.Join.ROUND
    }

    for (stroke in strokes) {
        if (stroke.points.isEmpty()) continue
        val baseColor = android.graphics.Color.valueOf(stroke.colorArgb.toInt())
        paint.color = when (stroke.tool) {
            BrushTool.ERASER -> android.graphics.Color.parseColor("#FFFDF8")
            BrushTool.MARKER -> android.graphics.Color.argb(
                98,
                (baseColor.red() * 255).toInt(),
                (baseColor.green() * 255).toInt(),
                (baseColor.blue() * 255).toInt()
            )
            BrushTool.PENCIL -> android.graphics.Color.argb(
                205,
                (baseColor.red() * 255).toInt(),
                (baseColor.green() * 255).toInt(),
                (baseColor.blue() * 255).toInt()
            )
            BrushTool.FINELINER -> stroke.colorArgb.toInt()
        }
        paint.strokeWidth = stroke.strokeWidthDp * density * 1.4f

        if (stroke.points.size == 1) {
            paint.style = Paint.Style.FILL
            canvas.drawCircle(
                stroke.points[0].x * sizePx,
                stroke.points[0].y * sizePx,
                paint.strokeWidth / 2f,
                paint
            )
            paint.style = Paint.Style.STROKE
        } else {
            val path = AndroidPath()
            path.moveTo(stroke.points[0].x * sizePx, stroke.points[0].y * sizePx)
            for (i in 1 until stroke.points.size) {
                val prev = stroke.points[i - 1]
                val curr = stroke.points[i]
                val midX = ((prev.x + curr.x) / 2f) * sizePx
                val midY = ((prev.y + curr.y) / 2f) * sizePx
                path.quadTo(prev.x * sizePx, prev.y * sizePx, midX, midY)
            }
            val last = stroke.points.last()
            path.lineTo(last.x * sizePx, last.y * sizePx)
            canvas.drawPath(path, paint)
        }
    }

    val dir = File(context.cacheDir, "drawings").apply { mkdirs() }
    val outFile = File(dir, "tekenstap_${System.currentTimeMillis()}.png")
    FileOutputStream(outFile).use { stream ->
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
    }

    val uri = FileProvider.getUriForFile(
        context,
        "${context.packageName}.fileprovider",
        outFile
    )
    val shareIntent = Intent(Intent.ACTION_SEND).apply {
        type = "image/png"
        putExtra(Intent.EXTRA_STREAM, uri)
        putExtra(Intent.EXTRA_SUBJECT, title)
        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
    }
    context.startActivity(
        Intent.createChooser(shareIntent, context.getString(R.string.share_drawing_title))
    )
}
