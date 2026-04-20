package com.memories.memories_recorder.feature.auth.login

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.memories.memories_recorder.navigation.Routes
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