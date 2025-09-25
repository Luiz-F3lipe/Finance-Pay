package com.luizf3lipe.financepay.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.luizf3lipe.financepay.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

// Lobster Two
val fontName = GoogleFont("Lato")

val fontFamily = FontFamily(
    Font(googleFont = fontName, fontProvider = provider)
)
// Set of Material typography styles to start with
val Typography = Typography()

val TitleLarge = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.ExtraBold,
    fontSize = 20.sp
)
val TitleMedium = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 16.sp,
)
val TitleSmall = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 14.sp,
)
val TitleExtraSmall = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 12.sp,
)
val Title2xs = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 10.sp,
)

val TextSmall = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
)
val TextSmallBold = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.SemiBold,
    fontSize = 14.sp,
)
val TextExtraSmall = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp,
)

val Input = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Normal,
    lineHeight = 24.sp,
    fontSize = 16.sp,
)
val ButtonMedium = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Normal,
    lineHeight = 24.sp,
    fontSize = 16.sp,
)
val ButtonSmall = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Normal,
    lineHeight = 20.sp,
    fontSize = 14.sp,
)