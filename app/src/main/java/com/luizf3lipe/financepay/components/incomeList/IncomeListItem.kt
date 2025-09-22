package com.luizf3lipe.financepay.components.incomeList

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luizf3lipe.financepay.ui.theme.Gray100
import com.luizf3lipe.financepay.ui.theme.Gray200

@Composable
fun IncomeListItem() {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(color = Gray100)
            .fillMaxWidth()
            .height(67.dp)
            .border(1.dp, Gray200, RoundedCornerShape(8.dp)),
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 16.dp)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.Center
        ) {

        }
    }
}

@Preview
@Composable
private fun IncomeListItemPrev() {
    IncomeListItem()
}