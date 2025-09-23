package com.luizf3lipe.financepay.screens.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luizf3lipe.financepay.components.debtorCard.DebtorCard
import com.luizf3lipe.financepay.components.header.Header
import com.luizf3lipe.financepay.components.monthSelector.MonthSelector
import com.luizf3lipe.financepay.components.primaryButton.PrimaryButton
import com.luizf3lipe.financepay.ui.theme.Gray100
import com.luizf3lipe.financepay.ui.theme.Gray200
import com.luizf3lipe.financepay.ui.theme.Gray300
import com.luizf3lipe.financepay.ui.theme.Primary
import com.luizf3lipe.financepay.ui.theme.TitleSmall
import java.time.Month

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Gray200),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Header()
            MonthSelector(
                selectedMonth = Month.SEPTEMBER,
                selectedYear = 2025,
                onMonthSelected = {_, _ -> },
                modifier = Modifier
                    .background(color = Gray200),
                showNavigationArrows = true,
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TextButton(
                        onClick = {},
                        contentPadding = PaddingValues(all = 0.dp),
                    ) {
                        Text(
                            text = "2025",
                            style = TitleSmall,
                            color = Primary,
                        )
                    }
                    TextButton(
                        onClick = {},
                        contentPadding = PaddingValues(all = 0.dp),
                    ) {
                        Text(
                            text = "Ver todos",
                            style = TitleSmall,
                            color = Primary
                        )
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState())
                        .padding(start = 16.dp, top = 4.dp, end = 16.dp)
                ) {
                    DebtorCard()
                    DebtorCard()
                    DebtorCard()
                    DebtorCard()
                    DebtorCard()
                }

                PrimaryButton(
                    title = "Adicionar Caloteiro",
                    onClick = {},
                    modifier = Modifier.padding(16.dp)
                )
            }
            Incomes(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp))
        }
    }
}

@Composable
fun Incomes(modifier: Modifier) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = Gray100,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp,
            pressedElevation = 8.dp
        )
    ) {
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun HomeScreenPrev() {
    HomeScreen()
}