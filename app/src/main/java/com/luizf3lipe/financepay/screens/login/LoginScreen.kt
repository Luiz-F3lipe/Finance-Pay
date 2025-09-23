package com.luizf3lipe.financepay.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.luizf3lipe.financepay.R
import com.luizf3lipe.financepay.components.inputs.InputIconPosition
import com.luizf3lipe.financepay.components.inputs.InputText
import com.luizf3lipe.financepay.components.primaryButton.PrimaryButton
import com.luizf3lipe.financepay.screens.navigation.Screens
import com.luizf3lipe.financepay.ui.theme.Gray100
import com.luizf3lipe.financepay.ui.theme.Gray300
import com.luizf3lipe.financepay.ui.theme.Gray500
import com.luizf3lipe.financepay.ui.theme.Gray700
import com.luizf3lipe.financepay.ui.theme.TextSmall
import com.luizf3lipe.financepay.ui.theme.TitleSmall

@Composable
fun LoginScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .background(color = Gray100)
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.systemBars)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(top = 8.dp, bottom = 8.dp, start = 12.dp, end = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.image_background),
                contentDescription = "Background Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(359.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(top = 40.dp, start = 32.dp, end = 32.dp),
            ) {
                Text(
                    text = "BOAS VINDAS!",
                    style = TitleSmall,
                    color = Gray700
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "Pronto para organizar suas finanças? Acesse agora",
                    style = TextSmall,
                    color = Gray500
                )
                Spacer(modifier = Modifier.size(28.dp))
                InputText(placeholder = "Nome")
                Spacer(modifier = Modifier.size(12.dp))
                InputText(placeholder = "E-mail")
                Spacer(modifier = Modifier.size(12.dp))
                InputText(
                    placeholder = "Senha",
                    iconRes = R.drawable.ic_eye_closed,
                    iconPosition = InputIconPosition.END

                )
                HorizontalDivider(
                    color = Gray300,
                    thickness = 2.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 28.dp)
                )
                PrimaryButton(
                    title = "Entrar",
                    onClick = {
                        navController.navigate(Screens.HomeRoot.route) {
                            popUpTo(Screens.Login.route) { inclusive = true }
                        }
                    },
                    modifier = Modifier
                )
            }
        }
    }
}