package com.fernanthonies.civapp.domain

import com.fernanthonies.civapp.data.AchievementType
import com.fernanthonies.civapp.data.CivAchievement
import com.fernanthonies.civapp.data.SteamPlayerAchievement
import com.fernanthonies.civapp.util.RegexUtil
import com.fernanthonies.civapp.util.random
import org.springframework.stereotype.Service
import java.util.*
import java.util.regex.Pattern
import javax.inject.Inject

@Service
class AchievementsInteractor @Inject constructor(val repo: IPlayerAchievements): IAchievementsInteractor {
    override fun earnedAchievements(userId: String, appId: String, steamKey: String): List<CivAchievement> {
        val earnedCheevos = repo.getPlayerAchievments(userId, appId, steamKey).filter {
            it.achieved == 1
        }
        return getAchievements(earnedCheevos, appId, steamKey)
    }

    override fun lockedAchievements(userId: String, appId: String, steamKey: String): List<CivAchievement> {
        val lockedCheevos = repo.getPlayerAchievments(userId, appId, steamKey).filter {
            it.achieved == 0
        }
        return getAchievements(lockedCheevos, appId, steamKey)
    }

    override fun suggestedAchievements(userId: String, appId: String, steamKey: String): List<CivAchievement> {
        val cheevos = lockedAchievements(userId, appId, steamKey)
        val earnedCheevos = earnedAchievements(userId, appId, steamKey)
        val leaderCheevos = cheevos.filter { it.achievementType == AchievementType.LEADER }
        val difficultyCheevos = cheevos.filter { it.achievementType == AchievementType.DIFFICULTY }
        val victoryCheevos = cheevos.filter { it.achievementType == AchievementType.VICTORY }
        val random = Random()

        val suggestedDifficulty: CivAchievement? = if (difficultyCheevos.any()) {
            difficultyCheevos.first()
        } else {
            earnedCheevos.filter { it.achievementType == AchievementType.DIFFICULTY }.random(random)
        }

        val suggestedVictory: CivAchievement? = if (victoryCheevos.any()) {
            victoryCheevos.random(random)
        } else {
            earnedCheevos.filter { it.achievementType == AchievementType.VICTORY }.random(random)
        }

        val suggestedLeader: CivAchievement? = if (leaderCheevos.any()) {
            leaderCheevos.random(random)
        } else {
            earnedCheevos.filter { it.achievementType == AchievementType.LEADER }.random(random)
        }

        return listOf(suggestedDifficulty!!, suggestedLeader!!, suggestedVictory!!)
    }

    private fun getAchievements(cheevos: List<SteamPlayerAchievement>, appId: String, steamKey: String): List<CivAchievement> {
        val cheevoDetails = repo.getGameAchievements(appId, steamKey)
        return cheevos.map { playerCheevo ->
            val gameCheevo = cheevoDetails.find { it.name == playerCheevo.apiName}
            if (gameCheevo != null) {
                val type: AchievementType = when {
                    Pattern.matches(RegexUtil.DIFFICULTY_REGEX, gameCheevo.description) -> AchievementType.DIFFICULTY
                    Pattern.matches(RegexUtil.LEADER_REGEX, gameCheevo.description) -> AchievementType.LEADER
                    Pattern.matches(RegexUtil.VICTORY_REGEX, gameCheevo.description) -> AchievementType.VICTORY
                    else -> AchievementType.OTHER
                }
                val url = if (playerCheevo.achieved == 1) gameCheevo.iconUrl else gameCheevo.grayIconUrl
                CivAchievement(gameCheevo.displayName, gameCheevo.description, url, type, playerCheevo.achieved == 0)
            } else {
                null
            }
        }.filter { it != null
        }.map { it!! }.filter { it.achievementType != AchievementType.OTHER }
    }
}