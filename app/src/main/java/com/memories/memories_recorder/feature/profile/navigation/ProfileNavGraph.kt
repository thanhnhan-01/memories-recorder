package com.memories.memories_recorder.feature.profile.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.memories.memories_recorder.core.navigation.Routes
import com.memories.memories_recorder.feature.profile.presentation.ProfileScreen

fun NavGraphBuilder.profileNavGraph(
    navController: NavHostController
) {
    composable(Routes.PROFILE) {
        ProfileScreen(navController)
    }
}