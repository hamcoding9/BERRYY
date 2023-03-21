package com.hamcoding.berryy.data

import com.hamcoding.berryy.data.model.DividendItem
import com.hamcoding.berryy.data.model.KrxItem
import com.hamcoding.berryy.data.model.RankItem
import com.hamcoding.berryy.data.source.remote.DetailApiClient
import com.hamcoding.berryy.data.source.remote.KrxApiClient
import com.hamcoding.berryy.data.source.remote.RankApiClient
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class RemoteStockRepository @Inject constructor(
    private val krxClient: KrxApiClient,
    private val rankClient: RankApiClient,
    private val detailClient: DetailApiClient,
) {
    suspend fun getSearchResult(word: String): List<KrxItem> {
        return krxClient.getStockList(word).response.body.items.item
    }

    suspend fun getRankList(): List<RankItem> {
        return rankClient.getRankList().body.items.rankItems
    }

    suspend fun getDetailList(code: String): List<DividendItem> {
        val dividendItems = mutableListOf(DividendItem("", "", "배당 기준일", "배당 지불일", "배당"))
        coroutineScope {
            launch {
                dividendItems.addAll(detailClient.getDetailList(code).response.body.items.item)
            }.join()
        }
        return dividendItems
    }
}