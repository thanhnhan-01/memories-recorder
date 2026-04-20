package com.memories.memories_recorder.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.memories.memories_recorder.feature.auth.forgot_password.ForgotPasswordScreen
import com.memories.memories_recorder.feature.auth.login.LoginScreen
import com.memories.memories_recorder.feature.auth.register.RegisterScreen

fun NavGraphBuilder.authGraph(
    navController: NavHostController
) {
    composable(Routes.LOGIN) {
        LoginScreen(
            onRegisterClick = {
                navController.navigate(Routes.REGISTER)
            },
          onForgotPasswordClick = {
              navController.navigate(Routes.FORGOT_PASSWORD)
          }
        )
    }

    composable(Routes.REGISTER) {
        RegisterScreen(
            onBackClick = {
                navController.popBackStack()
            }
        )
    }

    composable(Routes.FORGOT_PASSWORD) {
        ForgotPasswordScreen(
            onBackClick = {
                navController.popBackStack()
            }
        )
    }
}