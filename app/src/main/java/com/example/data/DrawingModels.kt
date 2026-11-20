package com.example.data

enum class LessonCategory(val label: String) {
    ALL("Alles"),
    BASIS("Basis"),
    DIEREN("Dieren"),
    NATUUR("Natuur"),
    GEZICHTEN("Gezichten"),
    DINGEN("Dingen")
}

enum class Difficulty(val label: String) {
    MAKKELIJK("Makkelijk"),
    GEMIDDELD("Gemiddeld"),
    UITDAGEND("Uitdagend")
}

enum class StrokeKind {
    CONSTRUCTION,
    OUTLINE,
    DETAIL,
    SHADING
}

sealed interface StrokeCommand {
    data class MoveTo(val x: Float, val y: Float) : StrokeCommand
    data class LineTo(val x: Float, val y: Float) : StrokeCommand
    data class QuadTo(val cx: Float, val cy: Float, val x: Float, val y: Float) : StrokeCommand
    data class CubicTo(
        val c1x: Float,
        val c1y: Float,
        val c2x: Float,
        val c2y: Float,
        val x: Float,
        val y: Float
    ) : StrokeCommand
    data class Circle(val cx: Float, val cy: Float, val radius: Float) : StrokeCommand
    data class Oval(val cx: Float, val cy: Float, val rx: Float, val ry: Float) : StrokeCommand
    data class Arc(
        val cx: Float,
        val cy: Float,
        val rx: Float,
        val ry: Float,
        val startAngle: Float,
        val sweepAngle: Float
    ) : StrokeCommand
}

data class LessonStroke(
    val commands: List<StrokeCommand>,
    val kind: StrokeKind = StrokeKind.OUTLINE,
    val widthScale: Float = 1f
)

data class DrawingStep(
    val stepNumber: Int,
    val title: String,
    val instruction: String,
    val tip: String,
    val strokes: List<LessonStroke>
)

data class DrawingLesson(
    val id: String,
    val title: String,
    val subtitle: String,
    val category: LessonCategory,
    val difficulty: Difficulty,
    val durationMinutes: Int,
    val pathOrder: Int,
    val accentHex: Long,
    val steps: List<DrawingStep>
)

enum class PracticeMode(val label: String) {
    ON_PAPER("Op Papier"),
    ON_SCREEN("Op Scherm")
}

enum class PaperGridStyle(val label: String) {
    NONE("Blanco"),
    DOTS("Puntjes"),
    GRID("Ruitjes")
}

enum class BrushTool(val label: String) {
    PENCIL("Potlood"),
    FINELINER("Fineliner"),
    MARKER("Markeer"),
    ERASER("Gum")
}

data class UserStrokePoint(
    val x: Float,
    val y: Float
)

data class UserStroke(
    val points: List<UserStrokePoint>,
    val colorArgb: Long,
    val strokeWidthDp: Float,
    val tool: BrushTool
)

data class UserPreferencesState(
    val completedLessonIds: Set<String> = emptySet(),
    val showConstructionLines: Boolean = true,
    val showGrid: Boolean = true,
    val playbackSpeed: Float = 1f,
    val lastOpenedLessonId: String? = null
)
