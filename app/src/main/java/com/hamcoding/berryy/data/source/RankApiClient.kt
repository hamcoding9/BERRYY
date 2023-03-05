package com.hamcoding.berryy.data.source

import com.hamcoding.berryy.BuildConfig
import com.hamcoding.berryy.data.model.RankResponse
import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface RankApiClient {

    @GET("getDividendRankN1")
    suspend fun getRankList(
        @Query("serviceKey") apiKey: String = BuildConfig.RANKING_API_KEY,
        @Query("year") year: Int = 2022,
        @Query("rankTpcd") rate: Int = 1,
    ): RankResponse

    companion object {

        private const val BASE_URL =
            "http://api.seibro.or.kr/openapi/service/StockSvc/"

        fun create(): RankApiClient {
            val logger = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            val parser = TikXml.Builder()
                .exceptionOnUnreadXml(false)
                .build()

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(TikXmlConverterFactory.create(parser))
                .build()
                .create(RankApiClient::class.java)
        }
    }
}