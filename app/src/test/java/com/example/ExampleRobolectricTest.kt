package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.LessonCatalog
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

    @Test
    fun `app name matches TekenStap`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val appName = context.getString(R.string.app_name)
        assertEquals("TekenStap", appName)
    }

    @Test
    fun `lesson catalog has 16 valid multi-step lessons`() {
        val lessons = LessonCatalog.allLessons
        assertEquals(16, lessons.size)
        lessons.forEach { lesson ->
            assertTrue("Lesson ${lesson.id} should have at least 5 steps", lesson.steps.size >= 5)
            lesson.steps.forEachIndexed { idx, step ->
                assertEquals(idx + 1, step.stepNumber)
                assertTrue("Step ${step.title} should have strokes", step.strokes.isNotEmpty())
            }
        }
    }
}
