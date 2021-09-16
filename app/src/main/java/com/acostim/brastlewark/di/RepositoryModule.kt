package com.acostim.brastlewark.di

import com.acostim.brastlewark.network.BrastlewarkService
import com.acostim.brastlewark.repository.BrastlewarkRepository
import com.acostim.brastlewark.repository.BrastlewarkRepositoryImpl
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