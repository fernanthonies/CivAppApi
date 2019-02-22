package com.fernanthonies.civapp.api

import com.fernanthonies.civapp.Components.DaggerServiceComponent
import com.fernanthonies.civapp.data.CivAchievement
import com.fernanthonies.civapp.domain.IAchievementsInteractor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.inject.Inject

@RestController
final class AchievementsController {

    @Inject
    lateinit var interactor: IAchievementsInteractor
    private val appId = "289070"

    init {
        DaggerServiceComponent.create().inject(this)
    }

    @GetMapping("/achievements/locked")
    fun lockedAchievments(@RequestParam(value = "userId") userId: String): List<CivAchievement> {
        return interactor.lockedAchievements(userId, appId)
    }

    @GetMapping("/achievements/unlocked")
    fun unlockedAchievments(@RequestParam(value = "userId") userId: String): List<CivAchievement> {
        return interactor.earnedAchievements(userId, appId)
    }

    @GetMapping("achievements/suggested")
    fun suggestedAchievements(@RequestParam(value = "userId") userId: String): List<CivAchievement> {
        return interactor.suggestedAchievements(userId, appId)
    }
}