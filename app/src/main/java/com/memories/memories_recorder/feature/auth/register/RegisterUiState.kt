package com.memories.memories_recorder.feature.auth.register

import androidx.compose.runtime.Immutable

/**
 * UiState for Register Screen
 */

@Immutable
data class RegisterUiState(
    val email: String = "",
    val username: String = "",
    val password: String = "",
    val passwordVisible: Boolean = false,
    val confirmPassword: String = "",
    val confirmPasswordVisible: Boolean = false,
    val isAcceptedTerms: Boolean = false,
    val registerRequestState: RegisterRequestState = RegisterRequestState.Idle
){
    val isLoading: Boolean
        get() = registerRequestState is RegisterRequestState.Loading

    val errorMessage: String?
        get() = (registerRequestState as? RegisterRequestState.Error)?.message
}

sealed class RegisterRequestState {
    object Idle : RegisterRequestState()
    object Loading : RegisterRequestState()
    object Success : RegisterRequestState()
    data class Error(val message: String) : RegisterRequestState()
}

sealed class RegisterAction {
    data class EmailChanged(val value: String) : RegisterAction()
    data class UsernameChanged(val value: String) : RegisterAction()
    data class PasswordChanged(val value: String) : RegisterAction()
    data class ConfirmPasswordChanged(val value: String) : RegisterAction()
    object TogglePassword : RegisterAction()
    object ToggleConfirmPassword : RegisterAction()
    data class TermsCheckedChanged(val checked: Boolean) : RegisterAction()
    object SubmitClicked : RegisterAction()
    object LoginClicked : RegisterAction()
}

sealed class RegisterEvent {
    object NavigateToLogin : RegisterEvent()
    object NavigateToHome : RegisterEvent()
}