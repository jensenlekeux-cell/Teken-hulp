package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.GridOn
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Replay
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.outlined.Movie
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.DrawingLesson
import com.example.data.DrawingStep
import com.example.data.PracticeMode

@Composable
fun VideoPlaybackControlsBar(
    isPlaying: Boolean,
    autoPlayAll: Boolean,
    stepProgress: Float,
    playbackSpeed: Float,
    showConstructionLines: Boolean,
    showGrid: Boolean,
    practiceMode: PracticeMode,
    ghostAlpha: Float,
    onTogglePlay: () -> Unit,
    onReplayStep: () -> Unit,
    onSeekProgress: (Float) -> Unit,
    onToggleAutoPlayAll: () -> Unit,
    onCycleSpeed: () -> Unit,
    onToggleConstruction: () -> Unit,
    onToggleGrid: () -> Unit,
    onCycleGhostAlpha: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(18.dp),
        color = MaterialTheme.colorScheme.surface,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                FilledTonalIconButton(
                    onClick = onTogglePlay,
                    modifier = Modifier.testTag("player_play_pause_button")
                ) {
                    Icon(
                        imageVector = if (isPlaying) Icons.Filled.Pause else Icons.Filled.PlayArrow,
                        contentDescription = if (isPlaying) "Pauzeren" else "Afspelen"
                    )
                }

                IconButton(
                    onClick = onReplayStep,
                    modifier = Modifier.testTag("player_replay_button")
                ) {
                    Icon(
                        imageVector = Icons.Filled.Replay,
                        contentDescription = "Stap opnieuw afspelen"
                    )
                }

                Slider(
                    value = stepProgress.coerceIn(0f, 1f),
                    onValueChange = onSeekProgress,
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 4.dp)
                        .testTag("player_progress_slider")
                )

                Surface(
                    color = MaterialTheme.colorScheme.surfaceVariant,
                    shape = RoundedCornerShape(50),
                    modifier = Modifier
                        .minimumInteractiveComponentSize()
                        .clip(RoundedCornerShape(50))
                        .clickable(onClick = onCycleSpeed)
                        .testTag("player_speed_button")
                ) {
                    val speedLabel = when {
                        playbackSpeed < 0.75f -> "0.5x"
                        playbackSpeed < 1.25f -> "1x"
                        else -> "1.5x"
                    }
                    Text(
                        text = speedLabel,
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                FilterChip(
                    selected = autoPlayAll,
                    onClick = onToggleAutoPlayAll,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Movie,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                    },
                    label = { Text("Filmpje", style = MaterialTheme.typography.labelSmall) },
                    modifier = Modifier.testTag("player_autoplay_chip")
                )

                FilterChip(
                    selected = showConstructionLines,
                    onClick = onToggleConstruction,
                    label = { Text("Hulplijnen", style = MaterialTheme.typography.labelSmall) },
                    modifier = Modifier.testTag("player_construction_chip")
                )

                FilterChip(
                    selected = showGrid,
                    onClick = onToggleGrid,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.GridOn,
                            contentDescription = null,
                            modifier = Modifier.size(15.dp)
                        )
                    },
                    label = { Text("Raster", style = MaterialTheme.typography.labelSmall) },
                    modifier = Modifier.testTag("player_grid_chip")
                )

                if (practiceMode == PracticeMode.ON_SCREEN) {
                    val ghostLabel = when {
                        ghostAlpha <= 0.01f -> "Gids: Uit"
                        ghostAlpha < 0.22f -> "Gids: Zacht"
                        else -> "Gids: Aan"
                    }
                    FilterChip(
                        selected = ghostAlpha > 0.01f,
                        onClick = onCycleGhostAlpha,
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Visibility,
                                contentDescription = null,
                                modifier = Modifier.size(15.dp)
                            )
                        },
                        label = { Text(ghostLabel, style = MaterialTheme.typography.labelSmall) },
                        modifier = Modifier.testTag("player_ghost_chip")
                    )
                }
            }
        }
    }
}

@Composable
fun TopStepNavigationBar(
    totalSteps: Int,
    currentIndex: Int,
    onSelectStep: (Int) -> Unit,
    onPrevious: () -> Unit,
    onNextOrFinish: () -> Unit,
    modifier: Modifier = Modifier
) {
    val isFirst = currentIndex == 0
    val isLast = currentIndex == totalSteps - 1

    Surface(
        shape = RoundedCornerShape(18.dp),
        color = MaterialTheme.colorScheme.surface,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
        tonalElevation = 1.dp,
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
        ) {
            OutlinedButton(
                onClick = onPrevious,
                enabled = !isFirst,
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
                modifier = Modifier
                    .minimumInteractiveComponentSize()
                    .testTag("step_previous_button")
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text("Vorige", style = MaterialTheme.typography.labelLarge)
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                for (idx in 0 until totalSteps) {
                    val active = idx == currentIndex
                    val done = idx < currentIndex
                    Box(
                        modifier = Modifier
                            .size(if (active) 11.dp else 8.dp)
                            .clip(CircleShape)
                            .background(
                                when {
                                    active -> MaterialTheme.colorScheme.primary
                                    done -> MaterialTheme.colorScheme.secondary
                                    else -> MaterialTheme.colorScheme.outline
                                }
                            )
                            .clickable { onSelectStep(idx) }
                    )
                }
            }

            Button(
                onClick = onNextOrFinish,
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isLast) {
                        MaterialTheme.colorScheme.secondary
                    } else {
                        MaterialTheme.colorScheme.primary
                    }
                ),
                contentPadding = PaddingValues(horizontal = 14.dp, vertical = 6.dp),
                modifier = Modifier
                    .minimumInteractiveComponentSize()
                    .testTag("step_next_button")
            ) {
                Text(
                    text = if (isLast) "Klaar!" else "Volgende stap",
                    style = MaterialTheme.typography.labelLarge
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    imageVector = if (isLast) Icons.Filled.Check else Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}

@Composable
fun StepInstructionCard(
    step: DrawingStep,
    totalSteps: Int,
    onSpeakInstruction: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(14.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Surface(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = RoundedCornerShape(50)
                ) {
                    Text(
                        text = "Stap ${step.stepNumber} van $totalSteps",
                        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                    )
                }

                // Read-aloud button for young kids
                Surface(
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    shape = RoundedCornerShape(50),
                    modifier = Modifier
                        .minimumInteractiveComponentSize()
                        .clip(RoundedCornerShape(50))
                        .clickable(onClick = onSpeakInstruction)
                        .testTag("step_speak_button")
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.VolumeUp,
                            contentDescription = "Lees stap voor",
                            tint = MaterialTheme.colorScheme.onSecondaryContainer,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Lees voor",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSecondaryContainer
                        )
                    }
                }
            }

            Text(
                text = step.title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = step.instruction,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )

            Surface(
                color = MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.5f),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Tip: ${step.tip}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp)
                )
            }
        }
    }
}

@Composable
fun LessonCompletedDialog(
    lesson: DrawingLesson,
    nextLesson: DrawingLesson?,
    canShareDrawing: Boolean,
    onShareDrawing: () -> Unit,
    onGoNextLesson: (String) -> Unit,
    onBackHome: () -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        icon = {
            Surface(
                color = MaterialTheme.colorScheme.tertiaryContainer,
                shape = CircleShape,
                modifier = Modifier.size(64.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Ster verdiend",
                        tint = MaterialTheme.colorScheme.tertiary,
                        modifier = Modifier.size(38.dp)
                    )
                }
            }
        },
        title = {
            Text(
                text = "Superknap gedaan!",
                style = MaterialTheme.typography.headlineSmall
            )
        },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = "Je hebt '${lesson.title}' helemaal afgetekend en een nieuwe ster verdiend!",
                    style = MaterialTheme.typography.bodyMedium
                )
                if (canShareDrawing) {
                    OutlinedButton(
                        onClick = onShareDrawing,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Share,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Deel mijn tekening")
                    }
                }
            }
        },
        confirmButton = {
            if (nextLesson != null) {
                Button(onClick = { onGoNextLesson(nextLesson.id) }) {
                    Text("Volgende: ${nextLesson.title}")
                }
            } else {
                Button(onClick = onBackHome) {
                    Text("Terug naar lessen")
                }
            }
        },
        dismissButton = {
            TextButton(onClick = onBackHome) {
                Text("Overzicht")
            }
        }
    )
}
