package com.memories.memories_recorder.feature.auth.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var uiState by mutableStateOf(LoginUiState())
        private set

    fun onEmailChange(email: String) {
        uiState = uiState.copy(email = email)
    }

    fun onPasswordChange(password: String) {
        uiState = uiState.copy(password = password)
    }

    fun onTogglePassword() {
        uiState = uiState.copy(
            passwordVisible = !uiState.passwordVisible
        )
    }

    fun onSubmit() {
        // TODO: call API
    }
}