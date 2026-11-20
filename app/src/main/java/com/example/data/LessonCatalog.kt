package com.example.data

object LessonCatalog {
    val allLessons: List<DrawingLesson> =
        (LessonCatalogPart1.lessons + LessonCatalogPart2.lessons).sortedBy { it.pathOrder }

    fun findById(id: String?): DrawingLesson? =
        allLessons.firstOrNull { it.id == id }

    fun nextLessonAfter(id: String): DrawingLesson? {
        val current = findById(id) ?: return null
        return allLessons.firstOrNull { it.pathOrder == current.pathOrder + 1 }
    }
}
