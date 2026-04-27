package com.memories.memories_recorder.feature.auth.register

import androidx.compose.runtime.Composable
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