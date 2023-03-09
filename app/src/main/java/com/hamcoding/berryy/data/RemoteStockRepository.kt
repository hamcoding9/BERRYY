package com.hamcoding.berryy.data

import com.hamcoding.berryy.data.model.KrxItem
import com.hamcoding.berryy.data.model.RankItem
import com.hamcoding.berryy.data.source.remote.KrxApiClient
import com.hamcoding.berryy.data.source.remote.RankApiClient
import javax.inject.Inject

class RemoteStockRepository @Inject constructor(
    private val krxClient: KrxApiClient,
    private val rankClient: RankApiClient
) {
    suspend fun getSearchResult(word: String): List<KrxItem> {
        return krxClient.getStockList(word).response.body.items.item
    }

    suspend fun getRankList(): List<RankItem> {
        return rankClient.getRankList().body.items.rankItems
    }
}