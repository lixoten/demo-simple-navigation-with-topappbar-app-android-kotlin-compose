package com.lixoten.fido.navigation

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.lixoten.fido.R
import com.lixoten.fido.presentation.fourth_screen.FourthScreen
import com.lixoten.fido.presentation.home_screen.HomeScreen
import com.lixoten.fido.presentation.item_detail_screen.ItemDetailScreen
import com.lixoten.fido.presentation.list_screen.ListScreen

sealed class Screen(val route: String, @StringRes val resourceId: Int, val routeArg: String = "", val routeWithArgs: String = "$route$routeArg") {
    object Home : Screen("home_scr", R.string.home_screen_name)
    object List : Screen("list_scr", R.string.list_screen_name)
    object Detail : Screen("item_detail_scr", R.string.item_detail_screen_name, routeArg = "?myId=")
    object Fourth : Screen("fourth_scr", R.string.fourth_screen_name, routeArg = "?myId=")
}

@Composable
fun FidoNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(
                modifier = Modifier.padding(8.dp),
                navController = navController,
            )
        }
        composable(route = Screen.List.route) {
            ListScreen(
                modifier = Modifier.padding(8.dp),
                navController = navController,
            )
        }
        composable(
            route = Screen.Detail.routeWithArgs + "{myId}",
            arguments = listOf(
                navArgument(
                    "myId"
                ) {
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ) { navBackStackEntry ->
            val myInt = navBackStackEntry.arguments?.getInt("myId")

            ItemDetailScreen(
                myInt = myInt ?: 0,
                modifier = Modifier.padding(8.dp),
                navController = navController,
            )
        }
        composable(
            route = Screen.Fourth.routeWithArgs + "{text}",
            arguments = listOf(
                navArgument(
                    "text"
                ) {
                    type = NavType.StringType
                }
            )
        ) { navBackStackEntry ->
            val myStrg = navBackStackEntry.arguments?.getString("text")

            FourthScreen(
                myStrg = myStrg ?: "xx",
                modifier = Modifier.padding(8.dp),
                navController = navController,
            )
        }
    }
}