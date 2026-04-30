package com.memories.memories_recorder.feature.auth.register

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.memories.memories_recorder.feature.auth.register.components.RegisterBody
import com.memories.memories_recorder.ui.utils.AppWrapContent

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

    AppWrapContent {
        RegisterBody(viewModel = viewModel)
    }
}