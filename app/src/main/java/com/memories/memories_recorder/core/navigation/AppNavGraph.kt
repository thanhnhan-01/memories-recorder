package com.memories.memories_recorder.core.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.memories.memories_recorder.feature.home.presentation.HomeScreen
import com.memories.memories_recorder.feature.profile.presentation.ProfileScreen
import com.memories.memories_recorder.core.designsystem.components.navigation.AppBottomBar
import com.memories.memories_recorder.feature.auth.navigation.authGraph

@Composable
fun AppNavGraph(
    navController: NavHostController,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val showBottomBar = currentRoute in listOf(
        Routes.HOME,
        Routes.PROFILE
    )

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                AppBottomBar(
                    currentRoute = currentRoute ?: "",
                    onNavigate = { route ->
                        navController.navigate(route) {
                            popUpTo(Routes.HOME)
                            launchSingleTop = true
                        }
                    },
                    onAddClick = {
                        navController.navigate(Routes.MEMORY_EDITOR)
                    }
                )
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Routes.LOGIN,
            modifier = Modifier.padding(paddingValues)
        ) {

            authGraph(navController)

            composable(route = Routes.HOME) {
                HomeScreen(navController = navController)
            }

            composable(route = Routes.MEMORY_EDITOR) {
//                HomeScreen(navController = navController)
            }

            composable(route = Routes.PROFILE) {
                ProfileScreen(navController = navController)
            }
        }
    }


}