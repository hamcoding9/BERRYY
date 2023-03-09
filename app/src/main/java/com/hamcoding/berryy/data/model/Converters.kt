package com.hamcoding.berryy.data.model

import androidx.room.TypeConverter
import com.google.gson.Gson

class Converters {

    private val gson = Gson()

    @TypeConverter
    fun stockToJson(stock: Stock): String {
        return gson.toJson(stock)
    }

    @TypeConverter
    fun stockFromJson(json: String): Stock? {
        return gson.fromJson(json, Stock::class.java)
    }

}