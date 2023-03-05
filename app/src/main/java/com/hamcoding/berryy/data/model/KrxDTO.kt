package com.hamcoding.berryy.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SearchResponse(
    val response: KrxResponse,
)

data class KrxResponse(
    val header: KrxHeader,
    val body: KrxBody,
) : Serializable

data class KrxBody(
    val items: KrxItemList
) : Serializable

data class KrxItemList(
    val item: List<KrxItem>
)

data class KrxItem(
    @SerializedName("itmsNm") val name: String,
    @SerializedName("crno") val companyCode: String,
) : Serializable

data class KrxHeader(
    val resultCode: String,
    val resultMsg: String,
) : Serializable