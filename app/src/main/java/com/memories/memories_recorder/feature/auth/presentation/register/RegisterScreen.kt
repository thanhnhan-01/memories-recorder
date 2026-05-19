package com.memories.memories_recorder.feature.auth.presentation.register

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.memories.memories_recorder.feature.auth.presentation.register.components.RegisterBody
import com.memories.memories_recorder.core.designsystem.components.layout.CenteredContent

@Composable
fun RegisterScreen(
    onNavigateToLogin: () -> Unit,
    onNavigateToHome: () -> Unit
) {
    val viewModel: RegisterViewModel = viewModel()

    LaunchedEffect(Unit) {
        viewModel.event.collect { event ->
            when (event) {
                RegisterEvent.NavigateToLogin -> onNavigateToLogin()
                RegisterEvent.NavigateToHome -> onNavigateToHome()
            }
        }
    }

    CenteredContent {
        RegisterBody(viewModel = viewModel)
    }
}