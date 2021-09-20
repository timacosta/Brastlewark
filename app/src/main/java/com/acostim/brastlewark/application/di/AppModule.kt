package com.acostim.brastlewark.application.di

import android.content.Context
import androidx.room.Room
import com.acostim.brastlewark.application.AppConstants.BASE_URL
import com.acostim.brastlewark.application.AppConstants.DATABASE_NAME
import com.acostim.brastlewark.data.local.AppDatabase
import com.acostim.brastlewark.data.remote.BrastlewarkService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRoomInstance(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        DATABASE_NAME
    ).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideGnomeDao(db: AppDatabase) = db.gnomeDao()

    @Singleton
    @Provides
    fun provideRetrofitInstance() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()

    @Singleton
    @Provides
    fun provideService(retrofit: Retrofit) = retrofit.create(BrastlewarkService::class.java)
}