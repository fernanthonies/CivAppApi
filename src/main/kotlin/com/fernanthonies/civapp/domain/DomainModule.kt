package com.fernanthonies.civapp.domain

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {
    @Provides
    @Singleton
    fun provideAchievementInteractor(achievementsInteractor: AchievementsInteractor): IAchievementsInteractor {
        return achievementsInteractor
    }

    @Provides
    @Singleton
    fun provideUserInteractor(userInteractor: UserInteractor): IUserInteractor {
        return userInteractor
    }
}