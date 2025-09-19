package com.luizf3lipe.financepay.components.inputs

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luizf3lipe.financepay.R
import com.luizf3lipe.financepay.ui.theme.Gray200
import com.luizf3lipe.financepay.ui.theme.Gray300
import com.luizf3lipe.financepay.ui.theme.Gray400
import com.luizf3lipe.financepay.ui.theme.Gray700
import com.luizf3lipe.financepay.ui.theme.Input
import com.luizf3lipe.financepay.ui.theme.Primary

@Composable
fun InputText(
    placeholder: String,
    @DrawableRes iconRes: Int? = null,
    iconPosition: InputIconPosition? = null
) {
    var text by remember { mutableStateOf("") }

    val leadingIcon: (@Composable (() -> Unit))? =
        if (iconRes != null && iconPosition == InputIconPosition.START) {
            { Image(painter = painterResource(id = iconRes), contentDescription = null, modifier = Modifier.size(22.dp)) }
        } else null

    val trailingIcon: (@Composable (() -> Unit))? =
        if (iconRes != null && iconPosition == InputIconPosition.END) {
            { Image(painter = painterResource(id = iconRes), contentDescription = null, modifier = Modifier.size(22.dp)) }
        } else null

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        placeholder = {
            Text(
                text = placeholder,
                color = Gray400,
                style = Input
            )
        },
        textStyle = Input,
        singleLine = true,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = Primary,
            focusedTextColor = Gray700,
            focusedBorderColor = Primary,
            unfocusedBorderColor = Gray300,
            focusedContainerColor = Gray200,
            unfocusedContainerColor = Gray200,
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .clip(RoundedCornerShape(8.dp))
    )
}

@Preview
@Composable
private fun InputTextPrev() {
    InputText(
        placeholder = "Email",
        iconRes = R.drawable.ic_eye_closed,
        iconPosition = InputIconPosition.END
    )
}