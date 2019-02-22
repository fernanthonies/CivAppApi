package com.fernanthonies.civapp.domain

import com.fernanthonies.civapp.data.CivAchievement

interface IAchievementsInteractor {
    fun earnedAchievements(userId: String, appId: String, steamKey: String): List<CivAchievement>
    fun lockedAchievements(userId: String, appId: String, steamKey: String): List<CivAchievement>
    fun suggestedAchievements(userId: String, appId: String, steamKey: String): List<CivAchievement>
}