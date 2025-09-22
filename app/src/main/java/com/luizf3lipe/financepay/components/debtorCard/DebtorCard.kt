package com.luizf3lipe.financepay.components.debtorCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luizf3lipe.financepay.R
import com.luizf3lipe.financepay.ui.theme.Gray200
import com.luizf3lipe.financepay.ui.theme.Gray300
import com.luizf3lipe.financepay.ui.theme.Gray400
import com.luizf3lipe.financepay.ui.theme.TitleSmall

@Composable
fun DebtorCard() {
    Box(
        modifier = Modifier
            .height(141.dp)
            .width(128.dp)
            .background(color = Gray200, shape = RoundedCornerShape(8.dp)),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Box(
                modifier = Modifier
                    .height(32.dp)
                    .width(32.dp)
                    .background(color = Gray300, shape = RoundedCornerShape(8.dp))
                    .border(1.dp, Gray400, RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_user_square),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Gray400)
                )
            }

            Spacer(modifier = Modifier.size(12.dp))

            Text(
                text = "Luiz Felipe Moraes Lima",
                style = TitleSmall
            )
        }
    }
}

@Preview
@Composable
private fun DebtorCardPrev() {
    DebtorCard()
}