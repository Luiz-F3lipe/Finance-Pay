package com.luizf3lipe.financepay.components.incomeList

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.luizf3lipe.financepay.R
import com.luizf3lipe.financepay.ui.theme.Danger
import com.luizf3lipe.financepay.ui.theme.Gray100
import com.luizf3lipe.financepay.ui.theme.Gray200
import com.luizf3lipe.financepay.ui.theme.Gray300
import com.luizf3lipe.financepay.ui.theme.Gray500
import com.luizf3lipe.financepay.ui.theme.Primary
import com.luizf3lipe.financepay.ui.theme.TextExtraSmall
import com.luizf3lipe.financepay.ui.theme.TitleMedium
import com.luizf3lipe.financepay.ui.theme.TitleSmall

@Composable
fun IncomeListItem() {
    Box(
        modifier = Modifier
            .background(color = Gray100)
            .fillMaxWidth()
            .height(67.dp)
            .drawBehind {
                drawLine(
                    color = Gray300,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = 1.dp.toPx()
                )
            }
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

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "IPhone 13",
                    style = TitleSmall
                )
                Text(
                    "08/10/2025",
                    style = TextExtraSmall,
                    color = Gray500
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
                    painter = painterResource(id = R.drawable.ic_trash),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                    colorFilter = ColorFilter.tint(color = Danger)
                )
            }
        }
    }
}