package com.example.criptoapp.presentation.coins_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.criptoapp.domain.model.Coin


@Composable
fun CoinListItem(
    modifier: Modifier = Modifier,
    coin: Coin,
    onItemClick: (Coin) -> Unit
) {
    Row(modifier = modifier
        .fillMaxWidth()
        .clickable { onItemClick(coin) }
        .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween) {
        Text(
            text = "${coin.rank} ${coin.name} (${coin.symbol})",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = if (coin.isActive) "active" else "inative",
            color = if (coin.isActive) Color.Green else Color.Red,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.align(CenterVertically)
        )
    }
}