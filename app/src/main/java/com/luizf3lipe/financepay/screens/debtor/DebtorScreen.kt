package com.luizf3lipe.financepay.screens.debtor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luizf3lipe.financepay.components.debtorCard.DebtorCardFullWidth
import com.luizf3lipe.financepay.components.header.Header
import com.luizf3lipe.financepay.components.primaryButton.PrimaryButton
import com.luizf3lipe.financepay.ui.theme.Gray200
import com.luizf3lipe.financepay.ui.theme.Primary
import com.luizf3lipe.financepay.ui.theme.TitleLarge

@Composable
fun DebtorScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Gray200)
    ) {
        // Header
        Header()

        // Título
        Text(
            modifier = Modifier.padding(
                top = 24.dp,
                bottom = 16.dp,
                start = 20.dp,
                end = 20.dp
            ),
            text = "Todos os Caloteiros",
            style = TitleLarge,
            color = Primary
        )

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentPadding = PaddingValues(
                start = 20.dp,
                end = 20.dp,
                bottom = 20.dp
            ),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Simulando uma lista de caloteiros - você pode substituir por dados reais
            items(12) { index ->
                DebtorCardFullWidth()
            }
        }

        PrimaryButton(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, bottom = 12.dp),
            title = "Adicionar Caloteiro",
            onClick = {}
        )
    }
}


@Preview
@Composable
private fun DebtorScreenPrev() {
    DebtorScreen()
}