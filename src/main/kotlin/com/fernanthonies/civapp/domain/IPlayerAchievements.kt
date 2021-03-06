package com.fernanthonies.civapp.domain

import com.fernanthonies.civapp.data.SteamGameAchievement
import com.fernanthonies.civapp.data.SteamPlayerAchievement
import org.json.JSONObject

interface IPlayerAchievements {
    fun getPlayerAchievments(userId: String, appId: String, steamKey: String): List<SteamPlayerAchievement>
    fun getGameAchievements(appId: String, steamKey: String): List<SteamGameAchievement>
}