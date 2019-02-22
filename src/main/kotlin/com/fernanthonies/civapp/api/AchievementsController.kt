package com.fernanthonies.civapp.api

import com.fernanthonies.civapp.Components.DaggerServiceComponent
import com.fernanthonies.civapp.Properties.ApplicationProperties
import com.fernanthonies.civapp.data.CivAchievement
import com.fernanthonies.civapp.domain.IAchievementsInteractor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.inject.Inject

@RestController
final class AchievementsController(private val properties: ApplicationProperties) {

    @Inject
    lateinit var interactor: IAchievementsInteractor

    init {
        DaggerServiceComponent.create().inject(this)
    }

    @GetMapping("/achievements/civ5/locked")
    fun locked5Achievments(@RequestParam(value = "userId") userId: String): List<CivAchievement> {
        return interactor.lockedAchievements(userId, properties.civ5AppId, properties.steamApiKey)
    }

    @GetMapping("/achievements/civ5/unlocked")
    fun unlocked5Achievments(@RequestParam(value = "userId") userId: String): List<CivAchievement> {
        return interactor.earnedAchievements(userId, properties.civ5AppId, properties.steamApiKey)
    }

    @GetMapping("achievements/civ5/suggested")
    fun suggested5Achievements(@RequestParam(value = "userId") userId: String): List<CivAchievement> {
        return interactor.suggestedAchievements(userId, properties.civ5AppId, properties.steamApiKey)
    }

    @GetMapping("/achievements/civ6/locked")
    fun locked6Achievments(@RequestParam(value = "userId") userId: String): List<CivAchievement> {
        return interactor.lockedAchievements(userId, properties.civ6AppId, properties.steamApiKey)
    }

    @GetMapping("/achievements/civ6/unlocked")
    fun unlocked6Achievments(@RequestParam(value = "userId") userId: String): List<CivAchievement> {
        return interactor.earnedAchievements(userId, properties.civ6AppId, properties.steamApiKey)
    }

    @GetMapping("achievements/civ6/suggested")
    fun suggested6Achievements(@RequestParam(value = "userId") userId: String): List<CivAchievement> {
        return interactor.suggestedAchievements(userId, properties.civ6AppId, properties.steamApiKey)
    }
}