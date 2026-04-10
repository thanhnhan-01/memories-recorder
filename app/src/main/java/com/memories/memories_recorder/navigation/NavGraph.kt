package com.memories.memories_recorder.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.memories.memories_recorder.feature.auth.forgot_password.ForgotPasswordScreen
import com.memories.memories_recorder.feature.auth.login.LoginScreen
import com.memories.memories_recorder.feature.auth.register.RegisterScreen
import com.memories.memories_recorder.feature.home.HomeScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String = Routes.AUTH,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        //
        composable(route = Routes.LOGIN) {
            LoginScreen(navController = navController)
        }

        //
        composable(route = Routes.REGISTER) {
            RegisterScreen(navController = navController)
        }

        composable(route = Routes.FORGOT_PASSWORD) {
            ForgotPasswordScreen(navController = navController)
        }

        // Home Screen
        composable(route = Routes.HOME) {
            HomeScreen(navController = navController)
        }
    }
}