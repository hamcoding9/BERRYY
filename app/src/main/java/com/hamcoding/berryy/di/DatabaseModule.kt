package com.hamcoding.berryy.di

import android.content.Context
import com.hamcoding.berryy.data.source.local.AppDatabase
import com.hamcoding.berryy.data.source.local.FavoriteStockDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun provideFavoriteStockDao(appDatabase: AppDatabase): FavoriteStockDao {
        return appDatabase.favoriteStockDao()
    }

}