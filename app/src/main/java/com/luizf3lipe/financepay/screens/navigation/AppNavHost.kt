package com.luizf3lipe.financepay.screens.navigation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.luizf3lipe.financepay.screens.debtor.DebtorScreen
import com.luizf3lipe.financepay.screens.home.HomeScreen
import com.luizf3lipe.financepay.screens.login.LoginScreen
import com.luizf3lipe.financepay.screens.splash.SplashScreen
import com.luizf3lipe.financepay.ui.theme.Gray100
import com.luizf3lipe.financepay.ui.theme.Gray200
import com.luizf3lipe.financepay.ui.theme.Primary
import com.luizf3lipe.financepay.R

// Data class para os itens do bottom nav


@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screens.HomeRoot.route
    ) {
        // Splash Screen
        composable(Screens.Splash.route) {
            SplashScreen(navController)
        }
        // Login Screen
        composable(Screens.Login.route) {
            LoginScreen(navController)
        }

        composable(Screens.HomeRoot.route) {
            ModernBottomNavScaffold()
        }
    }
}

@Composable
fun ModernBottomNavScaffold() {
    val bottomNavController = rememberNavController()
    val items = listOf(
        BottomNavItem(
            route = Screens.Home.route,
            title = "Despesas",
            selectedIcon = R.drawable.ic_stack_bold,
            unselectedIcon = R.drawable.ic_stack
        ),
        BottomNavItem(
            route = Screens.Debtors.route,
            title = "Devedores",
            selectedIcon = R.drawable.ic_users,
            unselectedIcon = R.drawable.ic_users_bold
        )
    )

    Scaffold(
        containerColor = Gray100,
        bottomBar = {
            ModernBottomNavigationBar(
                navController = bottomNavController,
                items = items
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = bottomNavController,
            startDestination = Screens.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screens.Home.route) { HomeScreen() }
            composable(Screens.Debtors.route) { DebtorScreen() }
        }
    }
}

@Composable
fun ModernBottomNavigationBar(
    navController: NavHostController,
    items: List<BottomNavItem>
) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    NavigationBar(
        containerColor = Gray200,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
        tonalElevation = 8.dp
    ) {
        items.forEach { item ->
            val isSelected = currentRoute == item.route

            val iconColor by animateColorAsState(
                targetValue = if (isSelected) Primary else Color.Gray.copy(alpha = 0.6f),
                animationSpec = tween(300),
                label = "iconColor"
            )

            val textColor by animateColorAsState(
                targetValue = if (isSelected) Primary else Color.Gray.copy(alpha = 0.8f),
                animationSpec = tween(300),
                label = "textColor"
            )

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = {
                    Image(
                        painter = painterResource(item.selectedIcon),
                        contentDescription = item.title,
                        colorFilter = ColorFilter.tint(iconColor),
                        modifier = Modifier.size(26.dp)
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        color = textColor,
                        fontSize = 12.sp,
                        fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Transparent,
                    unselectedIconColor = Color.Transparent,
                    selectedTextColor = Color.Transparent,
                    unselectedTextColor = Color.Transparent,
                    indicatorColor = Primary.copy(alpha = 0.12f)
                )
            )
        }
    }
}