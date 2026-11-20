package com.example.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.BrushTool
import com.example.data.DrawingLesson
import com.example.data.LessonCatalog
import com.example.data.LessonCategory
import com.example.data.PaperGridStyle
import com.example.data.PreferencesRepository
import com.example.data.UserPreferencesState
import com.example.data.UserStroke
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class SketchbookUiState(
    val strokes: List<UserStroke> = emptyList(),
    val redoStack: List<UserStroke> = emptyList(),
    val activeTool: BrushTool = BrushTool.PENCIL,
    val activeColorArgb: Long = 0xFF2B2622,
    val activeWidthDp: Float = 3.5f,
    val gridStyle: PaperGridStyle = PaperGridStyle.DOTS
)

class TekenStapViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = PreferencesRepository(application.applicationContext)

    val preferences: StateFlow<UserPreferencesState> = repository.preferencesFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = UserPreferencesState()
    )

    private val _selectedCategory = MutableStateFlow(LessonCategory.ALL)
    val selectedCategory: StateFlow<LessonCategory> = _selectedCategory.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    val filteredLessons: StateFlow<List<DrawingLesson>> = combine(
        _selectedCategory,
        _searchQuery
    ) { category, query ->
        LessonCatalog.allLessons.filter { lesson ->
            val matchesCat = category == LessonCategory.ALL || lesson.category == category
            val trimmed = query.trim()
            val matchesQuery = trimmed.isEmpty() ||
                lesson.title.contains(trimmed, ignoreCase = true) ||
                lesson.subtitle.contains(trimmed, ignoreCase = true) ||
                lesson.category.label.contains(trimmed, ignoreCase = true)
            matchesCat && matchesQuery
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = LessonCatalog.allLessons
    )

    private val _sketchbook = MutableStateFlow(SketchbookUiState())
    val sketchbook: StateFlow<SketchbookUiState> = _sketchbook.asStateFlow()

    fun selectCategory(category: LessonCategory) {
        _selectedCategory.value = category
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun onLessonOpened(lessonId: String) {
        viewModelScope.launch {
            repository.setLastOpenedLesson(lessonId)
        }
    }

    fun markLessonCompleted(lessonId: String) {
        viewModelScope.launch {
            repository.markLessonCompleted(lessonId)
        }
    }

    fun toggleLessonCompleted(lessonId: String) {
        viewModelScope.launch {
            repository.toggleLessonCompleted(lessonId)
        }
    }

    fun setShowConstructionLines(show: Boolean) {
        viewModelScope.launch {
            repository.setShowConstructionLines(show)
        }
    }

    fun setShowGrid(show: Boolean) {
        viewModelScope.launch {
            repository.setShowGrid(show)
        }
    }

    fun cyclePlaybackSpeed() {
        val current = preferences.value.playbackSpeed
        val next = when {
            current < 0.75f -> 1f
            current < 1.25f -> 1.5f
            else -> 0.5f
        }
        viewModelScope.launch {
            repository.setPlaybackSpeed(next)
        }
    }

    // Freehand Sketchbook actions
    fun addSketchStroke(stroke: UserStroke) {
        val state = _sketchbook.value
        _sketchbook.value = state.copy(
            strokes = state.strokes + stroke,
            redoStack = emptyList()
        )
    }

    fun undoSketch() {
        val state = _sketchbook.value
        if (state.strokes.isEmpty()) return
        val last = state.strokes.last()
        _sketchbook.value = state.copy(
            strokes = state.strokes.dropLast(1),
            redoStack = state.redoStack + last
        )
    }

    fun redoSketch() {
        val state = _sketchbook.value
        if (state.redoStack.isEmpty()) return
        val restored = state.redoStack.last()
        _sketchbook.value = state.copy(
            strokes = state.strokes + restored,
            redoStack = state.redoStack.dropLast(1)
        )
    }

    fun clearSketch() {
        val state = _sketchbook.value
        _sketchbook.value = state.copy(
            strokes = emptyList(),
            redoStack = emptyList()
        )
    }

    fun setSketchTool(tool: BrushTool) {
        _sketchbook.value = _sketchbook.value.copy(activeTool = tool)
    }

    fun setSketchColor(colorArgb: Long) {
        val currentTool = _sketchbook.value.activeTool
        _sketchbook.value = _sketchbook.value.copy(
            activeColorArgb = colorArgb,
            activeTool = if (currentTool == BrushTool.ERASER) BrushTool.PENCIL else currentTool
        )
    }

    fun setSketchWidth(widthDp: Float) {
        _sketchbook.value = _sketchbook.value.copy(activeWidthDp = widthDp)
    }

    fun setSketchGridStyle(style: PaperGridStyle) {
        _sketchbook.value = _sketchbook.value.copy(gridStyle = style)
    }
}
