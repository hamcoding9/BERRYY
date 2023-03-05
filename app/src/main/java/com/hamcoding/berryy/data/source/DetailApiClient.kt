package com.hamcoding.berryy.data.source

import com.hamcoding.berryy.BuildConfig
import com.hamcoding.berryy.data.model.DetailResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface DetailApiClient {

    @GET("getDiviInfo")
    suspend fun getDetailList(
        @Query("crno") companyCode: String,
        @Query("serviceKey") apiKey: String = BuildConfig.DETAIL_API_KEY,
        @Query("resultType") resultType: String = "JSON",
    ) : DetailResponse

    companion object {

        private const val BASE_URL =
            "http://apis.data.go.kr/1160100/service/GetStocDiviInfoService/"

        fun create(): DetailApiClient {
            val logger = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(DetailApiClient::class.java)

        }
    }
}