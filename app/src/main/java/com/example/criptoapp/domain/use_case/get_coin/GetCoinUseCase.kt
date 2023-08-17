package com.example.criptoapp.domain.use_case.get_coin

import com.example.criptoapp.common.Resource
import com.example.criptoapp.data.remote.dto.toCoin
import com.example.criptoapp.data.remote.dto.toCoinDetail
import com.example.criptoapp.domain.model.Coin
import com.example.criptoapp.domain.model.CoinDetail
import com.example.criptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Error inesperado"))
        } catch (e: IOException) {
            emit(Resource.Error("Cheque sua conexão com a internet"))
        }
    }
}