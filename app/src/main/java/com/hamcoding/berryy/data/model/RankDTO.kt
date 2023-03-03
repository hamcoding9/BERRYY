package com.hamcoding.berryy.data.model

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "response")
data class RankResponse(
    @Element(name = "header")
    val header: RankHeader,
    @Element(name = "body")
    val body: RankBody,
)

@Xml(name = "header")
data class RankHeader(
    @PropertyElement(name = "resultCode")
    val resultCode: Int,
    @PropertyElement(name = "resultMsg")
    val resultMsg: String,
)

@Xml(name = "body")
data class RankBody(
    @Element(name = "items")
    val items: Items,
    @PropertyElement(name = "numOfRows")
    val numOfRows: Int,
    @PropertyElement(name = "pageNo")
    val pageNo: Int,
    @PropertyElement(name = "totalCount")
    val totalCount: Int,
)

@Xml(name = "items")
data class Items(
    @Element(name = "item")
    val rankItems: List<RankItem>
)

@Xml
data class RankItem(
    @PropertyElement(name = "divAmtPerStk")
    val dividendAmount: String,
    @PropertyElement(name = "divRateCpri")
    val dividendRate: String,
    @PropertyElement(name = "korSecnNm")
    val name: String,
    @PropertyElement(name = "shotnIsin")
    val code: Int,
)