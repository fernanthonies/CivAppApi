package com.fernanthonies.civapp.data

import com.fernanthonies.civapp.domain.IPlayerAchievements
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import khttp.get
import org.springframework.stereotype.Repository

@Repository
class PlayerAchievementsRepository: IPlayerAchievements {

    override fun getPlayerAchievments(userId: String, appId: String): List<SteamPlayerAchievement> {
        val payload = mapOf("appid" to appId, "key" to "EEE219C67E9635ED67092862807F0BF8", "steamid" to userId)
        val result = get("http://api.steampowered.com/ISteamUserStats/GetPlayerAchievements/v0001/", params=payload)
        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, SteamPlayerAchievement::class.java)
        val adapter = moshi.adapter<List<SteamPlayerAchievement>>(type)
        val jsonarray = result.jsonObject.getJSONObject("playerstats").getJSONArray("achievements")
        return adapter.fromJson(jsonarray.toString())
    }

    override fun getGameAchievements(appId: String): List<SteamGameAchievement> {
        val payload = mapOf("appid" to appId, "key" to "EEE219C67E9635ED67092862807F0BF8")
        val result = get("http://api.steampowered.com/ISteamUserStats/GetSchemaForGame/v2/", params=payload)
        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, SteamGameAchievement::class.java)
        val adapter = moshi.adapter<List<SteamGameAchievement>>(type)
        val jsonArray = result.jsonObject.getJSONObject("game").getJSONObject("availableGameStats").getJSONArray("achievements")
        return adapter.fromJson(jsonArray.toString())
    }
}