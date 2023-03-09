package com.hamcoding.berryy.data

import com.hamcoding.berryy.data.model.FavoriteStock
import com.hamcoding.berryy.data.model.Stock
import com.hamcoding.berryy.data.source.local.AppDatabase
import com.hamcoding.berryy.data.source.local.FavoriteStockDao
import javax.inject.Inject

class FavoriteStockRepository @Inject constructor(private val favoriteStockDao: FavoriteStockDao) {

    suspend fun getFavoriteStocks(): List<FavoriteStock> {
        return favoriteStockDao.getFavoriteStocks()
    }

    suspend fun addFavoriteStock(stockList: List<Stock>) {
        val favoriteStockList = stockList.map {
            FavoriteStock(it)
        }
        favoriteStockDao.insert(favoriteStockList)
    }

}