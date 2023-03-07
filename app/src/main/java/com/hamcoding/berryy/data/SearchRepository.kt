package com.hamcoding.berryy.data

import android.util.Log
import com.hamcoding.berryy.data.model.DividendItem
import com.hamcoding.berryy.data.model.KrxItem
import com.hamcoding.berryy.data.source.DetailApiClient
import com.hamcoding.berryy.data.source.KrxApiClient
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchRepository @Inject constructor(
    private val krxClient: KrxApiClient
) {
    suspend fun getSearchResult(word: String): List<KrxItem> {
        return krxClient.getStockList(word).response.body.items.item
    }
}