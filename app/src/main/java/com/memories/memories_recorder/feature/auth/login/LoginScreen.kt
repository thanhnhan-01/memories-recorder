package com.memories.memories_recorder.feature.auth.login

import androidx.compose.runtime.Composable
import com.memories.memories_recorder.ui.utils.AppWrapContent

@Composable
fun LoginScreen(
    onRegisterClick: () -> Unit,
    onForgotPasswordClick: () -> Unit
) {
    AppWrapContent {
        LoginContent(
            onRegisterClick = onRegisterClick,
            onForgotPasswordClick = onForgotPasswordClick
        )
    }
}