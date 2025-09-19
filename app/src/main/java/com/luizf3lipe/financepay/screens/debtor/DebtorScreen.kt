package com.luizf3lipe.financepay.screens.debtor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.luizf3lipe.financepay.ui.theme.Gray100
import com.luizf3lipe.financepay.ui.theme.Gray200
import com.luizf3lipe.financepay.ui.theme.Primary
import com.luizf3lipe.financepay.ui.theme.TitleLarge

@Composable
fun DebtorScreen() {
    Box(
        modifier = Modifier.fillMaxSize().background(color = Gray100),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Debtor Screen Working!",
                style = TitleLarge,
                color = Primary
            )
        }
    }
}

@Preview
@Composable
private fun DebtorScreenPrev() {
    DebtorScreen()
}