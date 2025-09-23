package com.luizf3lipe.financepay.screens.navigation

sealed class Screens(val route: String) {
    object Splash : Screens("splash")
    object Login : Screens("login")
    object Home : Screens("home")
    object Debtors : Screens("debtors")
}