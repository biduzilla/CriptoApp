package com.example.criptoapp.presentation.coins_list

import com.example.criptoapp.domain.model.Coin

data class CoinsListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
