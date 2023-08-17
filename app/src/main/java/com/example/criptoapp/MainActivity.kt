package com.example.criptoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.criptoapp.presentation.Screens
import com.example.criptoapp.presentation.coins_details.CoinDetailsScreen
import com.example.criptoapp.presentation.coins_list.CoinListScren
import com.example.criptoapp.presentation.ui.theme.CriptoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CriptoAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screens.CoinListScreen.route
                ) {
                    composable(route = Screens.CoinListScreen.route) {
                        CoinListScren(navController)
                    }
                    composable(route = Screens.CoinDetailScreen.route + "/{coinId}") {
                        CoinDetailsScreen()
                    }
                }
            }
        }
    }
}
