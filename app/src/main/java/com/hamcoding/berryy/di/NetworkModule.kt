package com.hamcoding.berryy.di

import com.hamcoding.berryy.data.source.KrxApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideKrxApiClient(): KrxApiClient {
        return KrxApiClient.create()
    }
}