package com.example.ui.screens

import android.speech.tts.TextToSpeech
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Brush
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.data.BrushTool
import com.example.data.DrawingLesson
import com.example.data.LessonCatalog
import com.example.data.PaperGridStyle
import com.example.data.PracticeMode
import com.example.data.UserPreferencesState
import com.example.data.UserStroke
import com.example.ui.canvas.AnimatedTutorialCanvas
import com.example.ui.canvas.InteractiveSketchCanvas
import com.example.ui.canvas.shareDrawingAsPng
import kotlinx.coroutines.delay
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LessonPlayerScreen(
    lesson: DrawingLesson,
    preferences: UserPreferencesState,
    onBack: () -> Unit,
    onOpenLesson: (String) -> Unit,
    onLessonCompleted: (String) -> Unit,
    onToggleConstructionLines: (Boolean) -> Unit,
    onToggleGrid: (Boolean) -> Unit,
    onCycleSpeed: () -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler(onBack = onBack)

    val context = LocalContext.current
    var currentStepIndex by remember(lesson.id) { mutableIntStateOf(0) }
    var isPlaying by remember(lesson.id) { mutableStateOf(true) }
    var autoPlayAll by remember(lesson.id) { mutableStateOf(false) }
    var stepProgress by remember(lesson.id) { mutableFloatStateOf(0f) }
    var replayTrigger by remember(lesson.id) { mutableIntStateOf(0) }
    var practiceMode by remember(lesson.id) { mutableStateOf(PracticeMode.ON_PAPER) }
    var ghostAlpha by remember { mutableFloatStateOf(0.32f) }
    var showCompletionDialog by remember(lesson.id) { mutableStateOf(false) }

    // On-screen drawing state for this lesson
    var userStrokes by remember(lesson.id) { mutableStateOf<List<UserStroke>>(emptyList()) }
    var redoStack by remember(lesson.id) { mutableStateOf<List<UserStroke>>(emptyList()) }
    var activeTool by remember { mutableStateOf(BrushTool.PENCIL) }
    var activeColorArgb by remember { mutableStateOf(0xFF1E1A16L) }
    var activeWidthDp by remember { mutableStateOf(4.0f) }

    // Dutch Text-to-Speech for kids who want the step read aloud
    var ttsReady by remember { mutableStateOf(false) }
    val tts = remember {
        var engine: TextToSpeech? = null
        engine = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                engine?.language = Locale("nl", "NL")
                ttsReady = true
            }
        }
        engine
    }
    DisposableEffect(Unit) {
        onDispose {
            tts.stop()
            tts.shutdown()
        }
    }

    // Smooth video-style stroke animation loop
    LaunchedEffect(lesson.id, currentStepIndex, isPlaying, replayTrigger, preferences.playbackSpeed, autoPlayAll) {
        if (!isPlaying) return@LaunchedEffect
        if (stepProgress >= 0.999f) {
            stepProgress = 0f
        }
        val baseDurationMs = 2600f
        val durationMs = (baseDurationMs / preferences.playbackSpeed).coerceAtLeast(800f)
        var lastNanos = withFrameNanos { it }
        while (isPlaying && stepProgress < 1f) {
            val nowNanos = withFrameNanos { it }
            val deltaMs = (nowNanos - lastNanos) / 1_000_000f
            lastNanos = nowNanos
            stepProgress = (stepProgress + deltaMs / durationMs).coerceIn(0f, 1f)
        }
        if (stepProgress >= 1f) {
            if (autoPlayAll && currentStepIndex < lesson.steps.lastIndex) {
                delay(750)
                currentStepIndex += 1
                stepProgress = 0f
            } else {
                isPlaying = false
            }
        }
    }

    val currentStep = lesson.steps[currentStepIndex.coerceIn(0, lesson.steps.lastIndex)]
    val gridStyle = if (preferences.showGrid) PaperGridStyle.DOTS else PaperGridStyle.NONE

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = lesson.title,
                            style = MaterialTheme.typography.titleMedium,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = "${lesson.category.label} • Stap ${currentStepIndex + 1}/${lesson.steps.size}",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBack,
                        modifier = Modifier.testTag("player_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Terug naar overzicht"
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 6.dp)
        ) {
            // Mode Switcher: "Op Papier" (Watch video) vs "Op Scherm" (Trace & Draw)
            SingleChoiceSegmentedButtonRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("practice_mode_switcher")
            ) {
                PracticeMode.entries.forEachIndexed { index, mode ->
                    SegmentedButton(
                        selected = practiceMode == mode,
                        onClick = { practiceMode = mode },
                        shape = SegmentedButtonDefaults.itemShape(index = index, count = PracticeMode.entries.size),
                        icon = {
                            Icon(
                                imageVector = if (mode == PracticeMode.ON_PAPER) {
                                    Icons.Filled.MenuBook
                                } else {
                                    Icons.Filled.Brush
                                },
                                contentDescription = null,
                                modifier = Modifier.size(18.dp)
                            )
                        },
                        label = {
                            Text(
                                text = if (mode == PracticeMode.ON_PAPER) "Kijk & Op Papier" else "Teken Op Scherm",
                                style = MaterialTheme.typography.labelLarge,
                                maxLines = 1
                            )
                        },
                        modifier = Modifier.testTag("mode_tab_${mode.name.lowercase()}")
                    )
                }
            }

            // Main Drawing / Animation Canvas Card
            Surface(
                shape = RoundedCornerShape(24.dp),
                border = BorderStroke(1.5.dp, MaterialTheme.colorScheme.outline),
                tonalElevation = 2.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.02f)
                    .clip(RoundedCornerShape(24.dp))
                    .testTag("lesson_canvas_surface")
            ) {
                if (practiceMode == PracticeMode.ON_PAPER) {
                    AnimatedTutorialCanvas(
                        lesson = lesson,
                        currentStepIndex = currentStepIndex,
                        stepAnimationProgress = stepProgress,
                        showConstructionLines = preferences.showConstructionLines,
                        gridStyle = gridStyle,
                        ghostMode = false,
                        modifier = Modifier.fillMaxSize()
                    )
                } else {
                    InteractiveSketchCanvas(
                        strokes = userStrokes,
                        activeTool = activeTool,
                        activeColorArgb = activeColorArgb,
                        activeWidthDp = activeWidthDp,
                        gridStyle = gridStyle,
                        onAddStroke = { newStroke ->
                            userStrokes = userStrokes + newStroke
                            redoStack = emptyList()
                        },
                        underlayContent = {
                            if (ghostAlpha > 0.01f) {
                                AnimatedTutorialCanvas(
                                    lesson = lesson,
                                    currentStepIndex = currentStepIndex,
                                    stepAnimationProgress = stepProgress,
                                    showConstructionLines = preferences.showConstructionLines,
                                    gridStyle = PaperGridStyle.NONE,
                                    ghostMode = true,
                                    ghostAlpha = ghostAlpha,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        },
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            // Video-style Playback Controls
            VideoPlaybackControlsBar(
                isPlaying = isPlaying,
                autoPlayAll = autoPlayAll,
                stepProgress = stepProgress,
                playbackSpeed = preferences.playbackSpeed,
                showConstructionLines = preferences.showConstructionLines,
                showGrid = preferences.showGrid,
                practiceMode = practiceMode,
                ghostAlpha = ghostAlpha,
                onTogglePlay = {
                    if (!isPlaying && stepProgress >= 0.999f) {
                        stepProgress = 0f
                    }
                    isPlaying = !isPlaying
                },
                onReplayStep = {
                    stepProgress = 0f
                    isPlaying = true
                    replayTrigger++
                },
                onSeekProgress = { newProgress ->
                    isPlaying = false
                    stepProgress = newProgress
                },
                onToggleAutoPlayAll = {
                    autoPlayAll = !autoPlayAll
                    if (autoPlayAll && !isPlaying) {
                        if (stepProgress >= 0.999f && currentStepIndex < lesson.steps.lastIndex) {
                            currentStepIndex += 1
                            stepProgress = 0f
                        }
                        isPlaying = true
                    }
                },
                onCycleSpeed = onCycleSpeed,
                onToggleConstruction = { onToggleConstructionLines(!preferences.showConstructionLines) },
                onToggleGrid = { onToggleGrid(!preferences.showGrid) },
                onCycleGhostAlpha = {
                    ghostAlpha = when {
                        ghostAlpha > 0.25f -> 0.14f
                        ghostAlpha > 0.01f -> 0f
                        else -> 0.32f
                    }
                }
            )

            // Drawing Toolbar when in "Op Scherm" mode
            if (practiceMode == PracticeMode.ON_SCREEN) {
                StudioDrawingToolbar(
                    activeTool = activeTool,
                    activeColorArgb = activeColorArgb,
                    activeWidthDp = activeWidthDp,
                    canUndo = userStrokes.isNotEmpty(),
                    canRedo = redoStack.isNotEmpty(),
                    hasStrokes = userStrokes.isNotEmpty(),
                    onSelectTool = { activeTool = it },
                    onSelectColor = {
                        activeColorArgb = it
                        if (activeTool == BrushTool.ERASER) activeTool = BrushTool.PENCIL
                    },
                    onSelectWidth = { activeWidthDp = it },
                    onUndo = {
                        if (userStrokes.isNotEmpty()) {
                            redoStack = redoStack + userStrokes.last()
                            userStrokes = userStrokes.dropLast(1)
                        }
                    },
                    onRedo = {
                        if (redoStack.isNotEmpty()) {
                            userStrokes = userStrokes + redoStack.last()
                            redoStack = redoStack.dropLast(1)
                        }
                    },
                    onClear = {
                        userStrokes = emptyList()
                        redoStack = emptyList()
                    },
                    onShare = {
                        shareDrawingAsPng(context, userStrokes, lesson.title)
                    }
                )
            }

            // Step Instruction Card with Dutch Read-Aloud
            StepInstructionCard(
                step = currentStep,
                totalSteps = lesson.steps.size,
                currentIndex = currentStepIndex,
                onSelectStep = { idx ->
                    currentStepIndex = idx.coerceIn(0, lesson.steps.lastIndex)
                    stepProgress = 0f
                    isPlaying = true
                },
                onSpeakInstruction = {
                    if (ttsReady) {
                        val spokenText = "Stap ${currentStep.stepNumber}. ${currentStep.title}. ${currentStep.instruction}"
                        tts.speak(spokenText, TextToSpeech.QUEUE_FLUSH, null, "step_${currentStep.stepNumber}")
                    }
                },
                onPrevious = {
                    if (currentStepIndex > 0) {
                        currentStepIndex -= 1
                        stepProgress = 0f
                        isPlaying = true
                    }
                },
                onNextOrFinish = {
                    if (currentStepIndex < lesson.steps.lastIndex) {
                        currentStepIndex += 1
                        stepProgress = 0f
                        isPlaying = true
                    } else {
                        onLessonCompleted(lesson.id)
                        showCompletionDialog = true
                    }
                }
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }

    if (showCompletionDialog) {
        LessonCompletedDialog(
            lesson = lesson,
            nextLesson = LessonCatalog.nextLessonAfter(lesson.id),
            canShareDrawing = userStrokes.isNotEmpty(),
            onShareDrawing = { shareDrawingAsPng(context, userStrokes, lesson.title) },
            onGoNextLesson = { nextId ->
                showCompletionDialog = false
                onOpenLesson(nextId)
            },
            onBackHome = {
                showCompletionDialog = false
                onBack()
            },
            onDismiss = { showCompletionDialog = false }
        )
    }
}
