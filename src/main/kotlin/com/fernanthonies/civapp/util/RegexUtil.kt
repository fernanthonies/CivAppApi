package com.fernanthonies.civapp.util

class RegexUtil {
    companion object {
        const val DIFFICULTY_REGEX = "^(Win a regular game at)(.*)(difficulty or harder)\$"
        const val VICTORY_REGEX = "^(Win a regular game with a)(.*)(victory on any difficulty with any leader)\$"
        const val LEADER_REGEX = "^(Win a regular game as )(.*)\$"
    }
}