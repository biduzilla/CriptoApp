package com.example.criptoapp.data.repository

import com.example.criptoapp.data.remote.CoinPaprikaApi
import com.example.criptoapp.data.remote.dto.CoinDetailDto
import com.example.criptoapp.data.remote.dto.CoinDto
import com.example.criptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api: CoinPaprikaApi) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }

}