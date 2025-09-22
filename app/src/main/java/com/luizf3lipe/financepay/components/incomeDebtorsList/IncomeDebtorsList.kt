package com.luizf3lipe.financepay.components.incomeDebtorsList

import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import com.luizf3lipe.financepay.components.incomeList.IncomeListBackground
import com.luizf3lipe.financepay.components.incomeList.IncomeListItem

@Composable
fun IncomeDebtorsList(
    onEdit: () -> Void,
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
        content = {  },
        backgroundContent = {  },
        enableDismissFromEndToStart = true,
        enableDismissFromStartToEnd = false
    )
}