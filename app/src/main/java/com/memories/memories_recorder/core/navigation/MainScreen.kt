package com.memories.memories_recorder.core.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.memories.memories_recorder.core.designsystem.components.navigation.AppBottomBar

@Composable
fun MainScreen(
    rootNavController: NavHostController
) {
    val mainNavController = rememberNavController()

    val navBackStackEntry by mainNavController.currentBackStackEntryAsState()
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
                        mainNavController.navigate(route) {
                            popUpTo(Routes.HOME)
                            launchSingleTop = true
                        }
                    },
                    onAddClick = {
                        mainNavController.navigate(Routes.MEMORY_EDITOR)
                    }
                )
            }
        }
    ) { paddingValues ->
        MainNavGraph(
            navController = mainNavController,
            modifier = Modifier.padding(paddingValues)
        )
    }
}