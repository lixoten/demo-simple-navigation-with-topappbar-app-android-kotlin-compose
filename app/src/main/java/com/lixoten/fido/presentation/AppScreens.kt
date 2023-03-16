package com.lixoten.fido.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.lixoten.fido.navigation.FidoNavHost
import com.lixoten.fido.navigation.Screen
import com.lixoten.fido.presentation.components.AppTopBar

@Composable
fun DemoScreens() {
    // Notes: Set Nav Controller
    val navController = rememberNavController()

    // Notes: Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()

    // Notes: Get the name of the current screen check for null
    val currentScreen =
        backStackEntry?.destination?.route ?: Screen.Home.route

    // Notes: Boolean to check if we can navigate back. Check stack
    val canNavigateBack = navController.previousBackStackEntry != null

    val currentScreenResId = when {
        currentScreen.contains(Screen.Home.route) -> {
            Screen.Home.resourceId
        }
        currentScreen.contains(Screen.List.route) -> {
            Screen.List.resourceId
        }
        currentScreen.contains(Screen.Detail.route) -> {
            Screen.Detail.resourceId
        }
        currentScreen.contains(Screen.Fourth.route) -> {
            Screen.Fourth.resourceId
        }
        else -> {
            Screen.Home.resourceId
        }
    }

    Scaffold(
        topBar = {
            AppTopBar(
                currentScreenResId = currentScreenResId,
                canNavigateBack = canNavigateBack
            ) { navController.navigateUp() }
        },
    ) { innerPadding ->
        FidoNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}