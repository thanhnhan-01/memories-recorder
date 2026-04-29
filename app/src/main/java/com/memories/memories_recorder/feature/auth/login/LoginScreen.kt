package com.memories.memories_recorder.feature.auth.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.memories.memories_recorder.ui.utils.AppWrapContent

@Composable
fun LoginScreen(
    onNavigateToRegister: () -> Unit,
    onNavigateToForgot: () -> Unit,
    onNavigateToHome: () -> Unit
) {
    val viewModel: LoginViewModel = androidx.lifecycle.viewmodel.compose.viewModel()

    LaunchedEffect(Unit) {
        viewModel.event.collect { event ->
            when (event) {
                LoginEvent.NavigateToRegister -> onNavigateToRegister()
                LoginEvent.NavigateToForgotPassword -> onNavigateToForgot()
                LoginEvent.NavigateToHome -> onNavigateToHome()
            }
        }
    }

    AppWrapContent {
        LoginBody(viewModel = viewModel)
    }
}