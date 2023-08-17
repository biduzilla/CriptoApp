package com.example.criptoapp.presentation.coins_details

import com.example.criptoapp.domain.model.CoinDetail

data class CoinsDetailsState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
