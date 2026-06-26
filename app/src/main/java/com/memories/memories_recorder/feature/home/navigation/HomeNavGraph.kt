package com.memories.memories_recorder.feature.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.memories.memories_recorder.core.navigation.Routes
import com.memories.memories_recorder.feature.home.presentation.HomeScreen

fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController
) {
    composable(Routes.HOME) {
        HomeScreen(navController)
    }
}