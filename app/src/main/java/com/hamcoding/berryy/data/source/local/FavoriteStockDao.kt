package com.hamcoding.berryy.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.TypeConverters
import com.hamcoding.berryy.data.model.Converters
import com.hamcoding.berryy.data.model.FavoriteStock

@Dao
interface FavoriteStockDao {

    @Insert
    suspend fun insert(favoriteStockList: List<FavoriteStock>)

    @Query("SELECT * FROM favorite_stocks")
    suspend fun getFavoriteStocks(): List<FavoriteStock>

}