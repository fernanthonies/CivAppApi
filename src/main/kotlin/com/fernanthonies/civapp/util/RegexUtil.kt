package com.fernanthonies.civapp.util

class RegexUtil {
    companion object {
        const val CIV_6_DIFFICULTY_REGEX = "^(Win a regular game at)(.*)(difficulty or harder)\$"
        const val CIV_6_VICTORY_REGEX = "^(Win a regular game with a)(.*)(victory on any difficulty with any leader)\$"
        const val CIV_6_LEADER_REGEX = "^(Win a regular game as )(.*)\$"
        const val CIV_6_MAP_REGEX = "^(Win a regular game on a )(.*)(Map)\$"
        const val CIV_5_DIFFICULTY_REGEX = "^(Beat the game on the )(.*)(difficulty level.)\$"
        const val CIV_5_VICTORY_REGEX = "^(Win a )(.*)(Victory.)\$"
        const val CIV_5_LEADER_REGEX = "^(Beat the game on any difficulty setting as )(.*)\$"
        const val CIV_5_MAP_REGEX = "^(Beat the game on a )(.*)(Map.)\$"
    }
}