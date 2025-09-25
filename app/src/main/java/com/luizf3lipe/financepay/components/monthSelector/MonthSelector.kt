package com.luizf3lipe.financepay.components.monthSelector

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luizf3lipe.financepay.R
import com.luizf3lipe.financepay.ui.theme.Gray200
import com.luizf3lipe.financepay.ui.theme.Gray400
import com.luizf3lipe.financepay.ui.theme.Gray500
import com.luizf3lipe.financepay.ui.theme.Primary
import java.time.LocalDate
import java.time.Month
import java.time.format.TextStyle
import java.util.Locale

data class MonthData(
    val month: Month,
    val year: Int,
    val displayName: String
)

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MonthSelector(
    modifier: Modifier = Modifier,
    selectedMonth: Month = LocalDate.now().month,
    selectedYear: Int = LocalDate.now().year,
    onMonthSelected: (Month, Int) -> Unit = { _, _ -> },
    showNavigationArrows: Boolean = true,
    locale: Locale = Locale.forLanguageTag("pt-BR")
) {
    val currentDate = LocalDate.now()
    var currentSelectedMonth by remember { mutableStateOf(selectedMonth) }
    var currentSelectedYear by remember { mutableIntStateOf(selectedYear) }

    // Gerar lista de meses baseada na data atual
    val months = remember(currentDate) {
        generateMonthsList(currentDate.year, locale)
    }

    val listState = rememberLazyListState()

    // Encontrar índice do mês selecionado para scroll inicial
    val selectedIndex = months.indexOfFirst {
        it.month == currentSelectedMonth && it.year == currentSelectedYear
    }

    LaunchedEffect(selectedIndex) {
        if (selectedIndex != -1) {
            listState.animateScrollToItem(
                index = maxOf(0, selectedIndex - 1) // scroll para mostrar o mês anterior também
            )
        }
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Gray200)
            .padding(horizontal = if (showNavigationArrows) 8.dp else 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Seta esquerda
        if (showNavigationArrows) {
            NavigationArrow(
                isLeft = true,
                onClick = {
                    val currentIndex = months.indexOfFirst {
                        it.month == currentSelectedMonth && it.year == currentSelectedYear
                    }
                    if (currentIndex > 0) {
                        val previousMonth = months[currentIndex - 1]
                        currentSelectedMonth = previousMonth.month
                        currentSelectedYear = previousMonth.year
                        onMonthSelected(previousMonth.month, previousMonth.year)
                    }
                }
            )
        }

        // Lista de meses
        LazyRow(
            state = listState,
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            itemsIndexed(months) { index, monthData ->
                MonthItem(
                    monthData = monthData,
                    isSelected = monthData.month == currentSelectedMonth &&
                            monthData.year == currentSelectedYear,
                    isCurrent = monthData.month == currentDate.month &&
                            monthData.year == currentDate.year,
                    onClick = {
                        currentSelectedMonth = monthData.month
                        currentSelectedYear = monthData.year
                        onMonthSelected(monthData.month, monthData.year)
                    }
                )
            }
        }

        // Seta direita
        if (showNavigationArrows) {
            NavigationArrow(
                isLeft = false,
                onClick = {
                    val currentIndex = months.indexOfFirst {
                        it.month == currentSelectedMonth && it.year == currentSelectedYear
                    }
                    if (currentIndex < months.size - 1) {
                        val nextMonth = months[currentIndex + 1]
                        currentSelectedMonth = nextMonth.month
                        currentSelectedYear = nextMonth.year
                        onMonthSelected(nextMonth.month, nextMonth.year)
                    }
                }
            )
        }
    }
}

@Composable
private fun MonthItem(
    monthData: MonthData,
    isSelected: Boolean,
    isCurrent: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val backgroundColor = when {
        isSelected -> Primary.copy(alpha = 0.1f)
        else -> Color.Transparent
    }

    val textColor = when {
        isSelected -> Primary
        isCurrent -> Gray500
        else -> Gray400
    }

    Box(
        modifier = modifier
            .width(64.dp)
            .height(40.dp)
            .background(backgroundColor, RoundedCornerShape(8.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = monthData.displayName.uppercase(),
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 13.sp,
                fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Medium
            ),
            color = textColor,
            textAlign = TextAlign.Center
        )

        // Indicador para o mês selecionado
        if (isSelected) {
            Box(
                modifier = Modifier
                    .width(20.dp)
                    .height(2.dp)
                    .background(Primary, RoundedCornerShape(1.dp))
                    .align(Alignment.BottomCenter)
            )
        }
    }
}

@Composable
private fun NavigationArrow(
    isLeft: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(32.dp)
            .clip(RoundedCornerShape(6.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(
                id = if (isLeft) R.drawable.ic_chevron_left else R.drawable.ic_chevron_right
            ),
            contentDescription = if (isLeft) "Mês anterior" else "Próximo mês",
            tint = Gray400,
            modifier = Modifier.size(20.dp)
        )
    }
}

// Função helper para gerar lista de meses
@RequiresApi(Build.VERSION_CODES.O)
private fun generateMonthsList(
    year: Int,
    locale: Locale
): List<MonthData> {
    return Month.entries.map { month ->
        MonthData(
            month = month,
            year = year,
            displayName = month.getDisplayName(TextStyle.SHORT, locale).take(3)
        )
    }
}

// Versão compacta sem setas de navegação
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CompactMonthSelector(
    modifier: Modifier = Modifier,
    selectedMonth: Month = LocalDate.now().month,
    selectedYear: Int = LocalDate.now().year,
    onMonthSelected: (Month, Int) -> Unit = { _, _ -> },
) {
    MonthSelector(
        selectedMonth = selectedMonth,
        selectedYear = selectedYear,
        onMonthSelected = onMonthSelected,
        modifier = modifier,
        showNavigationArrows = false,
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
private fun MonthSelectorPreview() {
    Box(
        modifier = Modifier.padding(16.dp)
    ) {
        MonthSelector(
            selectedMonth = Month.MAY,
            onMonthSelected = { month, year ->
                println("Mês selecionado: $month/$year")
            }
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
private fun CompactMonthSelectorPreview() {
    Box(
        modifier = Modifier.padding(16.dp)
    ) {
        CompactMonthSelector(
            selectedMonth = Month.JUNE,
            onMonthSelected = { month, year ->
                println("Mês selecionado: $month/$year")
            }
        )
    }
}