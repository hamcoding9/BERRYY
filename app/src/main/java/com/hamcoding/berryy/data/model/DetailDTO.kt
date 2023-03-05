package com.hamcoding.berryy.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DetailResponse(
    val response: DividendResponse
) : Serializable

data class DividendResponse(
    val header: DividendHeader,
    val body: DividendBody,
) : Serializable

data class DividendBody(
    val items: DividendItemList
) : Serializable

data class DividendItemList(
    val item: List<DividendItem>
) : Serializable

data class DividendItem(
    @SerializedName("crno") val companyCode: String,
    @SerializedName("stckIssuCmpyNm") val companyName: String,
    @SerializedName("dvdnBasDt") val baseDate: String,
    @SerializedName("cashDvdnPayDt") val payDate: String,
    @SerializedName("stckGenrDvdnAmt") val amount: String,
)

data class DividendHeader(
    val resultCode: String,
    val resultMsg: String,
) : Serializable