package com.fernanthonies.civapp.data

import com.squareup.moshi.Json

data class SteamPlayerAchievement(@Json(name="apiname") val apiName: String, val achieved: Int, @Json(name="unlocktime") val unlockTime: String)