package com.acostim.brastlewark.application.di

import com.acostim.brastlewark.data.remote.BrastlewarkService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton
import com.acostim.brastlewark.application.AppConstants.BASE_URL

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder().build()
    }


    @Provides
    @Singleton
    fun provideRetrofitInstance() : Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
    }

    @Provides
    @Singleton
    fun provideBrastlewarkService(retrofit: Retrofit.Builder) : BrastlewarkService {
        return retrofit.build().create(BrastlewarkService::class.java)
    }

}