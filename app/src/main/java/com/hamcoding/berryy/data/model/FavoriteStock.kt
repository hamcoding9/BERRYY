package com.hamcoding.berryy.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "favorite_stocks"
)
data class FavoriteStock(
    val stock: Stock,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

data class Stock(
    val name: String,
    val dividendAmount: String,
    val dividendRate: String,
) : java.io.Serializable