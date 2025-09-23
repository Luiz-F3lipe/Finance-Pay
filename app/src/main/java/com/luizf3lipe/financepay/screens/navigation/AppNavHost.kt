package com.luizf3lipe.financepay.screens.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.luizf3lipe.financepay.screens.home.HomeScreen
import com.luizf3lipe.financepay.screens.login.LoginScreen
import com.luizf3lipe.financepay.screens.splash.SplashScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screens.Splash.route) {
        composable(Screens.Splash.route) { SplashScreen(navController = navController) }
        composable(Screens.Login.route) { LoginScreen(navController = navController) }
        composable(Screens.Home.route) { HomeScreen() }
    }
}