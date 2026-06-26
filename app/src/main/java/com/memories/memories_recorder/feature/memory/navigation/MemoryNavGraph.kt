package com.memories.memories_recorder.feature.memory.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.memories.memories_recorder.core.navigation.Routes
import com.memories.memories_recorder.feature.memory.presentation.editor.MemoryEditorScreen

fun NavGraphBuilder.memoryNavGraph(
    navController: NavHostController
) {
    composable(Routes.MEMORY_EDITOR) {
        MemoryEditorScreen(navController)
    }
}