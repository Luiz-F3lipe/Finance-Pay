package com.luizf3lipe.financepay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.luizf3lipe.financepay.ui.theme.FinancePayTheme
import com.luizf3lipe.financepay.screens.navigation.AppNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FinancePayTheme {
                AppNavHost()
            }
        }
    }
}