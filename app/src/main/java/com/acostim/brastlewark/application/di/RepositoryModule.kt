package com.acostim.brastlewark.application.di

import com.acostim.brastlewark.data.remote.BrastlewarkService
import com.acostim.brastlewark.domain.BrastlewarkRepository
import com.acostim.brastlewark.domain.BrastlewarkRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideBrastlewarkRepository(
        brastlewarkService: BrastlewarkService
    ): BrastlewarkRepository {
        return BrastlewarkRepositoryImpl(brastlewarkService)
    }
}