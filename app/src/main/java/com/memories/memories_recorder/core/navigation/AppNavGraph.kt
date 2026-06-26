package com.memories.memories_recorder.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.memories.memories_recorder.feature.auth.navigation.authNavGraph

@Composable
fun AppNavGraph(
    rootNavController: NavHostController,
) {

    NavHost(
        navController = rootNavController,
        startDestination = AppGraph.AUTH
    ) {
        authNavGraph(rootNavController)

        composable(AppGraph.MAIN ) {
            MainScreen(rootNavController)
        }
    }
}