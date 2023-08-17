package com.example.criptoapp.presentation.coins_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.criptoapp.common.Constants
import com.example.criptoapp.common.Resource
import com.example.criptoapp.domain.use_case.get_coin.GetCoinUseCase
import com.example.criptoapp.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinsListViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoinsDetailsState())
    val state: State<CoinsDetailsState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getCoin(coinId)
        }
    }

    private fun getCoin(coinId: String) {
        getCoinUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _state.value = CoinsDetailsState(
                        isLoading = true,
                        error = result.message ?: "Error inesperado"
                    )
                }

                is Resource.Loading -> {
                    _state.value = CoinsDetailsState(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value = CoinsDetailsState(coin = result.data ?: null)
                }
            }
        }.launchIn(viewModelScope)
    }
}