package com.luizf3lipe.financepay.ui.theme.screens.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.luizf3lipe.financepay.ui.theme.screens.splash.SplashScreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ) {
        // Splash Screen
        composable(Screens.Splash.route) {
            SplashScreen(navController)
        }
    }
}