package com.luizf3lipe.financepay.components.incomeDebtorsList

import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun IncomeDebtorsList(
    onEdit: () -> Unit,
) {
    val dismissState = rememberSwipeToDismissBoxState(
        confirmValueChange = {
            if (it == SwipeToDismissBoxValue.EndToStart) {
                onEdit()
            }
            false
        }
    )

    SwipeToDismissBox(
        state = dismissState,
        content = { IncomeDebtorsListItem() },
        backgroundContent = { IncomeDebtorsListBackground() },
        enableDismissFromEndToStart = true,
        enableDismissFromStartToEnd = false
    )
}

@Preview
@Composable
private fun IncomeDebtorsListPrev() {
    IncomeDebtorsList(onEdit = { })
}