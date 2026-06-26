package com.memories.memories_recorder

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.memories.memories_recorder.core.designsystem.theme.MemoriesRecorderTheme
import com.memories.memories_recorder.core.navigation.AppNavGraph

@Composable
fun App() {
    MemoriesRecorderTheme {
        val rootNavController = rememberNavController()

        AppNavGraph(
            rootNavController = rootNavController
        )
    }
}