package com.luizf3lipe.financepay.components.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luizf3lipe.financepay.R
import com.luizf3lipe.financepay.ui.theme.Gray100
import com.luizf3lipe.financepay.ui.theme.Gray500
import com.luizf3lipe.financepay.ui.theme.TextSmall
import com.luizf3lipe.financepay.ui.theme.TitleSmall

@Composable
fun Header() {
    Box(
        modifier = Modifier
            .background(color = Gray100)
            .fillMaxWidth()
            .height(90.dp)
            .windowInsetsPadding(WindowInsets.systemBars),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = "Bem vindo!", style = TitleSmall)
                Text(text = "Vamos organizar suas finanças?!", style = TextSmall, color = Gray500)
            }

            Image(
                painter = painterResource(id = R.drawable.ic_logout),
                contentDescription = "Sair logo",
            )
        }
    }
}

@Preview
@Composable
private fun HeaderPrev() {
    Header()
}