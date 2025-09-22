package com.luizf3lipe.financepay.components.incomeDebtorsList

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luizf3lipe.financepay.R
import com.luizf3lipe.financepay.ui.theme.Gray100
import com.luizf3lipe.financepay.ui.theme.Gray200
import com.luizf3lipe.financepay.ui.theme.Gray300
import com.luizf3lipe.financepay.ui.theme.Primary
import com.luizf3lipe.financepay.ui.theme.TextExtraSmall
import com.luizf3lipe.financepay.ui.theme.TextSmallBold
import com.luizf3lipe.financepay.ui.theme.TitleMedium

@Composable
fun IncomeDebtorsListItem() {
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
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .height(32.dp)
                    .width(32.dp)
                    .background(color = Gray200, shape = RoundedCornerShape(8.dp))
                    .border(1.dp, Gray300, RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_basket),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    colorFilter = ColorFilter.tint(color = Primary)
                )
            }

            Spacer(modifier = Modifier.size(12.dp))

            Row(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Luiz Felipe",
                    style = TextSmallBold
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = "R$",
                    style = TextExtraSmall,
                )
                Text(
                    text = "179,90",
                    style = TitleMedium
                )
                Spacer(modifier = Modifier.size(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_edit),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                    colorFilter = ColorFilter.tint(color = Primary)
                )
            }
        }
    }
}

@Preview
@Composable
private fun IncomeDebtorsListItemPrev() {
    IncomeDebtorsListItem()
}