package com.luizf3lipe.financepay.ui.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// Accent colors
val Primary = Color(0xFFDA4BDD)
val Danger = Color(0xFFD93A4A)
val Success = Color(0xFF1FA342)

// Base Colors
val Gray100 = Color(0xFFF9FBF9)
val Gray200 = Color(0xFFEFF0EF)
val Gray300 = Color(0xFFE5E6E5)
val Gray400 = Color(0xFFA1A2A1)
val Gray500 = Color(0xFF676767)
val Gray600 = Color(0xFF494A49)
val Gray700 = Color(0xFF0F0F0F)

// Gradient Colors
val GradientBlack = Brush.linearGradient(
    colors = listOf(Color(0xFF0F0F0F), Color(0xFF2D2D2D)),
    start = Offset.Zero,
    end = Offset.Infinite // isso faz o Compose adaptar ao tamanho disponível
)