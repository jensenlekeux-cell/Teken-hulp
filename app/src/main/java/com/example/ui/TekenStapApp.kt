package com.example.ui

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Brush
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Brush
import androidx.compose.material.icons.outlined.Explore
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.data.LessonCatalog
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.LearningPathScreen
import com.example.ui.screens.LessonPlayerScreen
import com.example.ui.screens.SketchbookScreen

object TekenStapRoutes {
    const val HOME = "home"
    const val PATH = "path"
    const val SKETCHBOOK = "sketchbook"
    const val LESSON_PLAYER = "lesson/{lessonId}"

    fun lessonRoute(lessonId: String): String = "lesson/$lessonId"
}

private enum class TopLevelTab(
    val route: String,
    val label: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
) {
    HOME(
        route = TekenStapRoutes.HOME,
        label = "Lessen",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home
    ),
    PATH(
        route = TekenStapRoutes.PATH,
        label = "Leerpad",
        selectedIcon = Icons.Filled.Explore,
        unselectedIcon = Icons.Outlined.Explore
    ),
    SKETCHBOOK(
        route = TekenStapRoutes.SKETCHBOOK,
        label = "Schetsboek",
        selectedIcon = Icons.Filled.Brush,
        unselectedIcon = Icons.Outlined.Brush
    )
}

@Composable
fun TekenStapApp(
    viewModel: TekenStapViewModel = viewModel()
) {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    val preferences by viewModel.preferences.collectAsStateWithLifecycle()
    val filteredLessons by viewModel.filteredLessons.collectAsStateWithLifecycle()
    val selectedCategory by viewModel.selectedCategory.collectAsStateWithLifecycle()
    val searchQuery by viewModel.searchQuery.collectAsStateWithLifecycle()
    val sketchbookState by viewModel.sketchbook.collectAsStateWithLifecycle()

    val isTopLevel = currentRoute in TopLevelTab.entries.map { it.route }

    fun navigateToTab(route: String) {
        navController.navigate(route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    fun openLesson(lessonId: String) {
        viewModel.onLessonOpened(lessonId)
        navController.navigate(TekenStapRoutes.lessonRoute(lessonId)) {
            launchSingleTop = true
        }
    }

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val useRail = maxWidth >= 600.dp

        Scaffold(
            contentWindowInsets = WindowInsets.safeDrawing,
            containerColor = MaterialTheme.colorScheme.background,
            bottomBar = {
                if (isTopLevel && !useRail) {
                    NavigationBar(
                        containerColor = MaterialTheme.colorScheme.surface
                    ) {
                        TopLevelTab.entries.forEach { tab ->
                            val selected = currentRoute == tab.route
                            NavigationBarItem(
                                selected = selected,
                                onClick = { navigateToTab(tab.route) },
                                icon = {
                                    Icon(
                                        imageVector = if (selected) tab.selectedIcon else tab.unselectedIcon,
                                        contentDescription = tab.label
                                    )
                                },
                                label = { Text(tab.label) },
                                modifier = Modifier.testTag("nav_tab_${tab.route}")
                            )
                        }
                    }
                }
            }
        ) { innerPadding ->
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                if (isTopLevel && useRail) {
                    NavigationRail(
                        containerColor = MaterialTheme.colorScheme.surface
                    ) {
                        TopLevelTab.entries.forEach { tab ->
                            val selected = currentRoute == tab.route
                            NavigationRailItem(
                                selected = selected,
                                onClick = { navigateToTab(tab.route) },
                                icon = {
                                    Icon(
                                        imageVector = if (selected) tab.selectedIcon else tab.unselectedIcon,
                                        contentDescription = tab.label
                                    )
                                },
                                label = { Text(tab.label) },
                                modifier = Modifier.testTag("rail_tab_${tab.route}")
                            )
                        }
                    }
                }

                NavHost(
                    navController = navController,
                    startDestination = TekenStapRoutes.HOME,
                    modifier = Modifier.weight(1f)
                ) {
                    composable(TekenStapRoutes.HOME) {
                        HomeScreen(
                            lessons = filteredLessons,
                            selectedCategory = selectedCategory,
                            searchQuery = searchQuery,
                            preferences = preferences,
                            onSelectCategory = viewModel::selectCategory,
                            onSearchQueryChange = viewModel::updateSearchQuery,
                            onOpenLesson = ::openLesson
                        )
                    }

                    composable(TekenStapRoutes.PATH) {
                        LearningPathScreen(
                            preferences = preferences,
                            onOpenLesson = ::openLesson
                        )
                    }

                    composable(TekenStapRoutes.SKETCHBOOK) {
                        SketchbookScreen(
                            uiState = sketchbookState,
                            onAddStroke = viewModel::addSketchStroke,
                            onUndo = viewModel::undoSketch,
                            onRedo = viewModel::redoSketch,
                            onClear = viewModel::clearSketch,
                            onSelectTool = viewModel::setSketchTool,
                            onSelectColor = viewModel::setSketchColor,
                            onSelectWidth = viewModel::setSketchWidth,
                            onSelectGridStyle = viewModel::setSketchGridStyle
                        )
                    }

                    composable(
                        route = TekenStapRoutes.LESSON_PLAYER,
                        arguments = listOf(navArgument("lessonId") { type = NavType.StringType })
                    ) { entry ->
                        val lessonId = entry.arguments?.getString("lessonId")
                        val lesson = LessonCatalog.findById(lessonId) ?: LessonCatalog.allLessons.first()
                        LessonPlayerScreen(
                            lesson = lesson,
                            preferences = preferences,
                            onBack = { navController.popBackStack() },
                            onOpenLesson = { nextId ->
                                viewModel.onLessonOpened(nextId)
                                navController.navigate(TekenStapRoutes.lessonRoute(nextId)) {
                                    popUpTo(TekenStapRoutes.LESSON_PLAYER) { inclusive = true }
                                }
                            },
                            onLessonCompleted = viewModel::markLessonCompleted,
                            onToggleConstructionLines = viewModel::setShowConstructionLines,
                            onToggleGrid = viewModel::setShowGrid,
                            onCycleSpeed = viewModel::cyclePlaybackSpeed
                        )
                    }
                }
            }
        }
    }
}
