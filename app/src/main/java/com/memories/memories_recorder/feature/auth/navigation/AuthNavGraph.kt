package com.memories.memories_recorder.feature.auth.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.memories.memories_recorder.core.navigation.AppGraph
import com.memories.memories_recorder.core.navigation.Routes
import com.memories.memories_recorder.feature.auth.presentation.forgot_password.ForgotPasswordScreen
import com.memories.memories_recorder.feature.auth.presentation.login.LoginScreen
import com.memories.memories_recorder.feature.auth.presentation.register.RegisterScreen

fun NavGraphBuilder.authNavGraph(
    rootNavController: NavHostController
) {

    navigation(
        route = AppGraph.AUTH,
        startDestination = Routes.LOGIN
    ) {
        composable(Routes.LOGIN) {
            LoginScreen(
                onNavigateToRegister = {
                    rootNavController.navigate(Routes.REGISTER)
                },
                onNavigateToForgot = {
                    rootNavController.navigate(Routes.FORGOT_PASSWORD)
                },
                onNavigateToHome = {
                    rootNavController.navigate(Routes.MAIN_GRAPH) {
                        popUpTo(Routes.AUTH_GRAPH) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(Routes.REGISTER) {
            RegisterScreen(
                onNavigateToLogin = {
                    rootNavController.navigate(Routes.LOGIN)
                },

                onNavigateToHome = {
                    rootNavController.navigate(Routes.HOME)
                },
            )
        }

        composable(Routes.FORGOT_PASSWORD) {
            ForgotPasswordScreen(
                onBackClick = {
                    rootNavController.popBackStack()
                }
            )
        }
    }
}