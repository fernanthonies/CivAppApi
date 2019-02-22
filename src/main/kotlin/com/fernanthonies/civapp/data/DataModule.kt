package com.fernanthonies.civapp.data

import com.fernanthonies.civapp.domain.IPlayerAchievements
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {
    @Provides
    @Singleton
    fun provideAchievementRepo(): IPlayerAchievements {
        return PlayerAchievementsRepository()
    }
}