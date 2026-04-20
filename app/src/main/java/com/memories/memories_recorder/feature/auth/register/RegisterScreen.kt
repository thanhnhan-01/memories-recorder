package com.memories.memories_recorder.feature.auth.register

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.memories.memories_recorder.navigation.Routes
import com.memories.memories_recorder.ui.utils.AppWrapContent

@Composable
fun RegisterScreen(
    onBackClick: () -> Unit
) {
    AppWrapContent {
        RegisterContent(
            onLoginClick = onBackClick
        )
    }
}