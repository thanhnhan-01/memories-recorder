package com.memories.memories_recorder.feature.auth.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {
    var uiState by mutableStateOf(RegisterUiState())
        private set

    fun onEmailChange(email: String) {
        uiState = uiState.copy(email = email)
    }

    fun onUsernameChange(username: String) {
        uiState = uiState.copy(username = username)
    }

    fun onPasswordChange(password: String) {
        uiState = uiState.copy(password = password)
    }

    fun onTogglePassword() {
        uiState = uiState.copy(passwordVisible = !uiState.passwordVisible)
    }

    fun onConfirmPasswordChange(confirmPassword: String) {
        uiState = uiState.copy(confirmPassword = confirmPassword )
    }

    fun onToggleConfirmPassword() {
        uiState = uiState.copy(confirmPasswordVisible = !uiState.confirmPasswordVisible)
    }

    fun onToggleTerms(checked : Boolean) {
        uiState = uiState.copy(isAcceptedTerms = checked)
    }

    fun onSubmit() {
        viewModelScope.launch {
            uiState = uiState.copy(registerRequestState = RegisterRequestState.Loading)

            delay(1500)

            uiState = uiState.copy(registerRequestState = RegisterRequestState.Success)
        }
    }

//    private fun validate(): String? {
//        if (uiState.email.isBlank()) return "Email is required"
//        if (uiState.username.isBlank()) return "Username is required"
//        if (uiState.password.isBlank()) return "Password is required"
//        if (uiState.confirmPassword.isBlank()) return "Confirm password is required"
//        if (uiState.password != uiState.confirmPassword) return "Passwords do not match"
//        if (!uiState.isAcceptedTerms) return "You must accept terms"
//        return null
//    }

    fun resetForm() {
//        uiState = RegisterUiState()
    }
}