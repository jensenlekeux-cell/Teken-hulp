package com.example.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "tekenstap_prefs")

class PreferencesRepository(private val context: Context) {

    private object Keys {
        val COMPLETED_LESSONS = stringSetPreferencesKey("completed_lessons")
        val SHOW_CONSTRUCTION = booleanPreferencesKey("show_construction")
        val SHOW_GRID = booleanPreferencesKey("show_grid")
        val PLAYBACK_SPEED = floatPreferencesKey("playback_speed")
        val LAST_LESSON_ID = stringPreferencesKey("last_lesson_id")
    }

    val preferencesFlow: Flow<UserPreferencesState> = context.dataStore.data.map { prefs ->
        UserPreferencesState(
            completedLessonIds = prefs[Keys.COMPLETED_LESSONS] ?: emptySet(),
            showConstructionLines = prefs[Keys.SHOW_CONSTRUCTION] ?: true,
            showGrid = prefs[Keys.SHOW_GRID] ?: true,
            playbackSpeed = prefs[Keys.PLAYBACK_SPEED] ?: 1f,
            lastOpenedLessonId = prefs[Keys.LAST_LESSON_ID]
        )
    }

    suspend fun markLessonCompleted(lessonId: String) {
        context.dataStore.edit { prefs ->
            val current = prefs[Keys.COMPLETED_LESSONS] ?: emptySet()
            prefs[Keys.COMPLETED_LESSONS] = current + lessonId
        }
    }

    suspend fun toggleLessonCompleted(lessonId: String) {
        context.dataStore.edit { prefs ->
            val current = prefs[Keys.COMPLETED_LESSONS] ?: emptySet()
            prefs[Keys.COMPLETED_LESSONS] = if (lessonId in current) current - lessonId else current + lessonId
        }
    }

    suspend fun setLastOpenedLesson(lessonId: String) {
        context.dataStore.edit { prefs ->
            prefs[Keys.LAST_LESSON_ID] = lessonId
        }
    }

    suspend fun setShowConstructionLines(show: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[Keys.SHOW_CONSTRUCTION] = show
        }
    }

    suspend fun setShowGrid(show: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[Keys.SHOW_GRID] = show
        }
    }

    suspend fun setPlaybackSpeed(speed: Float) {
        context.dataStore.edit { prefs ->
            prefs[Keys.PLAYBACK_SPEED] = speed
        }
    }
}
