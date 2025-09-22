package com.luizf3lipe.financepay.components.incomeDebtorsList

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.luizf3lipe.financepay.R
import com.luizf3lipe.financepay.ui.theme.Danger
import com.luizf3lipe.financepay.ui.theme.Gray100
import com.luizf3lipe.financepay.ui.theme.Primary

@Composable
fun IncomeDebtorsListBackground(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Primary)
            .padding(end = 20.dp),
        contentAlignment = Alignment.CenterEnd
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_edit),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            colorFilter = ColorFilter.tint(color = Gray100)
        )
    }
}