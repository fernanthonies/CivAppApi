package com.fernanthonies.civapp.Components

import com.fernanthonies.civapp.api.AchievementsController
import com.fernanthonies.civapp.data.DataModule
import com.fernanthonies.civapp.domain.DomainModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(DataModule::class), (DomainModule::class)])
interface ServiceComponent {
    fun inject(achievementsController: AchievementsController)
}