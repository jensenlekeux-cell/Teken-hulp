package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.data.BrushTool
import com.example.data.PaperGridStyle
import com.example.data.UserStroke
import com.example.ui.SketchbookUiState
import com.example.ui.canvas.InteractiveSketchCanvas
import com.example.ui.canvas.shareDrawingAsPng

private val KidDrawingPrompts = listOf(
    "Teken een vrolijke draak die bellen blaast!",
    "Teken jouw droomboomhut met een touwladder.",
    "Maak een grappig monstertje met 3 ogen en een hoed.",
    "Teken een raket op weg naar een planeet vol snoep.",
    "Teken je lievelingsdier met een coole zonnebril!"
)

@Composable
fun SketchbookScreen(
    uiState: SketchbookUiState,
    onAddStroke: (UserStroke) -> Unit,
    onUndo: () -> Unit,
    onRedo: () -> Unit,
    onClear: () -> Unit,
    onSelectTool: (BrushTool) -> Unit,
    onSelectColor: (Long) -> Unit,
    onSelectWidth: (Float) -> Unit,
    onSelectGridStyle: (PaperGridStyle) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var showIdeas by remember { mutableStateOf(false) }
    var promptIndex by remember { mutableIntStateOf(0) }

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        // Header + Paper style chips
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Vrij Schetsboek",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = "Teken lekker wat je zelf wilt!",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                PaperGridStyle.entries.forEach { style ->
                    FilterChip(
                        selected = uiState.gridStyle == style,
                        onClick = { onSelectGridStyle(style) },
                        label = { Text(style.label, style = MaterialTheme.typography.labelSmall) },
                        modifier = Modifier.testTag("paper_style_${style.name.lowercase()}")
                    )
                }
            }
        }

        // Collapsible Inspiration Banner Card
        Card(
            shape = MaterialTheme.shapes.medium,
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
            modifier = Modifier
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.medium)
                .clickable { showIdeas = !showIdeas }
                .testTag("sketch_ideas_toggle")
        ) {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 14.dp, vertical = 10.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Filled.AutoAwesome,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Weet je even niet wat je moet tekenen?",
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                    Icon(
                        imageVector = if (showIdeas) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                        contentDescription = if (showIdeas) "Inklappen" else "Uitklappen"
                    )
                }

                AnimatedVisibility(visible = showIdeas) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(112.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img_free_sketch_banner),
                            contentDescription = "Schetsboek inspiratie banner",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    Brush.horizontalGradient(
                                        listOf(Color(0xDD1E1A16), Color(0x881E1A16))
                                    )
                                )
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(14.dp)
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "TEKENIDEE:",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = Color(0xFFFFE6B8)
                                )
                                Text(
                                    text = KidDrawingPrompts[promptIndex],
                                    style = MaterialTheme.typography.titleSmall,
                                    color = Color.White
                                )
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Surface(
                                color = MaterialTheme.colorScheme.primary,
                                shape = RoundedCornerShape(50),
                                modifier = Modifier
                                    .clip(RoundedCornerShape(50))
                                    .clickable {
                                        promptIndex = (promptIndex + 1) % KidDrawingPrompts.size
                                    }
                                    .testTag("next_prompt_button")
                            ) {
                                Text(
                                    text = "Nieuw idee",
                                    style = MaterialTheme.typography.labelMedium,
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                                )
                            }
                        }
                    }
                }
            }
        }

        // Spacious Freehand Canvas
        Surface(
            shape = RoundedCornerShape(24.dp),
            border = BorderStroke(1.5.dp, MaterialTheme.colorScheme.outline),
            tonalElevation = 2.dp,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .clip(RoundedCornerShape(24.dp))
                .testTag("free_sketch_canvas")
        ) {
            InteractiveSketchCanvas(
                strokes = uiState.strokes,
                activeTool = uiState.activeTool,
                activeColorArgb = uiState.activeColorArgb,
                activeWidthDp = uiState.activeWidthDp,
                gridStyle = uiState.gridStyle,
                onAddStroke = onAddStroke,
                modifier = Modifier.fillMaxSize()
            )
        }

        // Studio Toolbar
        StudioDrawingToolbar(
            activeTool = uiState.activeTool,
            activeColorArgb = uiState.activeColorArgb,
            activeWidthDp = uiState.activeWidthDp,
            canUndo = uiState.strokes.isNotEmpty(),
            canRedo = uiState.redoStack.isNotEmpty(),
            hasStrokes = uiState.strokes.isNotEmpty(),
            onSelectTool = onSelectTool,
            onSelectColor = onSelectColor,
            onSelectWidth = onSelectWidth,
            onUndo = onUndo,
            onRedo = onRedo,
            onClear = onClear,
            onShare = { shareDrawingAsPng(context, uiState.strokes, "Mijn Schets") }
        )
    }
}
