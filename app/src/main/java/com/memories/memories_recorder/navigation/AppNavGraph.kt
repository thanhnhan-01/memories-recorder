package com.memories.memories_recorder.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.memories.memories_recorder.feature.home.HomeScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Routes.LOGIN,
    ) {

        authGraph(navController)

        // Home Screen
        composable(route = Routes.HOME) {
            HomeScreen(navController = navController)
        }
    }
}