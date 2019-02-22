package com.fernanthonies.civapp.data

data class CivAchievement(val title: String, val description: String, val imageUrl: String, val achievementType: AchievementType, val locked: Boolean = true)

enum class AchievementType {
    LEADER, DIFFICULTY, VICTORY, OTHER
}