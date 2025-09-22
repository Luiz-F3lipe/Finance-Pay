package com.luizf3lipe.financepay.components.incomeList

import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun IncomeList(
    onRemove: () -> Unit
) {
    val dismissState = rememberSwipeToDismissBoxState(
        confirmValueChange = {
            if (it == SwipeToDismissBoxValue.EndToStart) {
                onRemove()
            }
            false
        }
    )

    SwipeToDismissBox(
        state = dismissState,
        content = { IncomeListItem() },
        backgroundContent = { IncomeListBackground() },
        enableDismissFromEndToStart = true,
        enableDismissFromStartToEnd = false
    )
}


@Preview
@Composable
private fun IncomeListItemPrev() {
    IncomeList(onRemove = {})
}