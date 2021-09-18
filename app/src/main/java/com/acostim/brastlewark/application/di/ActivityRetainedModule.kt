package com.acostim.brastlewark.application.di

import com.acostim.brastlewark.domain.BrastlewarkRepository
import com.acostim.brastlewark.domain.BrastlewarkRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class ActivityRetainedModule {
    @Binds
    abstract fun dataSource(impl: BrastlewarkRepositoryImpl): BrastlewarkRepository
}