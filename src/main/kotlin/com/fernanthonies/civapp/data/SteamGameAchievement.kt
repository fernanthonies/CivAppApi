package com.fernanthonies.civapp.data

import com.squareup.moshi.Json

data class SteamGameAchievement(val name: String, @Json(name="defaultvalue") val defaultValue: String,@Json(name="displayName") val displayName: String, val hidden: String, val description: String,@Json(name="icon") val iconUrl: String,@Json(name="icongray") val grayIconUrl: String)