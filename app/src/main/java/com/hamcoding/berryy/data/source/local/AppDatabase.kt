package com.hamcoding.berryy.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hamcoding.berryy.data.model.Converters
import com.hamcoding.berryy.data.model.FavoriteStock

@Database(entities = [FavoriteStock::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun favoriteStockDao(): FavoriteStockDao

    companion object {

        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "berry-db"
            ).build().also {
                instance = it
            }
        }
    }
}