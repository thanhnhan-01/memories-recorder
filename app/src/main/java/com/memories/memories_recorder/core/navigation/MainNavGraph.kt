package com.memories.memories_recorder.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.memories.memories_recorder.feature.home.navigation.homeNavGraph
import com.memories.memories_recorder.feature.memory.navigation.memoryNavGraph
import com.memories.memories_recorder.feature.profile.navigation.profileNavGraph

@Composable
fun MainNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Routes.HOME,
        modifier = modifier
    ) {
        homeNavGraph(navController)

        memoryNavGraph(navController)

        profileNavGraph(navController)
    }
}