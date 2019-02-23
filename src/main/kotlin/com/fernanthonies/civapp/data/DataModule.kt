package com.fernanthonies.civapp.data

import com.fernanthonies.civapp.domain.IPlayerAchievements
import com.fernanthonies.civapp.domain.IUserInfo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {
    @Provides
    @Singleton
    fun provideAchievementRepo(cheevoRepository: PlayerAchievementsRepository): IPlayerAchievements {
        return cheevoRepository
    }

    @Provides
    @Singleton
    fun provideUserRepo(userRepo: UserInfoRepository): IUserInfo {
        return userRepo
    }
}