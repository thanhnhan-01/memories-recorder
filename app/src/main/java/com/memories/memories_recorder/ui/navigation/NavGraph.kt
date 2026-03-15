package com.memories.memories_recorder.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.memories.memories_recorder.ui.screens.auth.login.LoginScreen
import com.memories.memories_recorder.ui.screens.auth.register.RegisterScreen
import com.memories.memories_recorder.ui.screens.home.HomeScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String = Routes.LOGIN,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        // Login Screen
        composable(route = Routes.LOGIN) {
            LoginScreen(navController = navController)
        }

        // Register Screen
        composable(route = Routes.REGISTER) {
            RegisterScreen(navController = navController)
        }

        // Home Screen
        composable(route = Routes.HOME) {
            HomeScreen(navController = navController)
        }
    }
}