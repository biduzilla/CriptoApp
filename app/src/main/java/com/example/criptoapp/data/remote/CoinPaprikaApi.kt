package com.example.criptoapp.data.remote

import com.example.criptoapp.data.remote.dto.CoinDto
import com.example.criptoapp.data.remote.dto.CoinDetailDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}