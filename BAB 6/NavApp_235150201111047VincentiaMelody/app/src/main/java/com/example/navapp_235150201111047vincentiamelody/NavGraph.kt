package com.example.navapp_235150201111047vincentiamelody

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavType
import androidx.navigation.navArgument

object Destinations {
    const val HOME = "home"
    const val DETAIL = "detail/{message}"
    const val PROFILE = "profile"
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Destinations.HOME) {
        composable(Destinations.HOME) {
            HomeScreen(navController)
        }
        composable(
            route = Destinations.DETAIL,
            arguments = listOf(navArgument("message") { type = NavType.StringType })
        ) { backStackEntry -> DetailScreen(backStackEntry.arguments?.getString("message"))
    }
        composable(Destinations.PROFILE) {
            ProfileScreen(navController)
        }
    }
}
