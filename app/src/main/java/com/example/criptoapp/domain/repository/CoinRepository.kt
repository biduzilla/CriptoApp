package com.example.criptoapp.domain.repository

import com.example.criptoapp.data.remote.dto.CoinDetailDto
import com.example.criptoapp.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}