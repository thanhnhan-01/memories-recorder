package com.memories.memories_recorder.feature.auth.login

import androidx.compose.runtime.Immutable

/**
 * UiState for Login Screen
 */

@Immutable
data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val passwordVisible: Boolean = false,
    val loginRequestState: LoginRequestState = LoginRequestState.Idle
) {
    val isLoading: Boolean
        get() = loginRequestState is LoginRequestState.Loading

    val errorMessage: String?
        get() = (loginRequestState as? LoginRequestState.Error)?.message
}


sealed class LoginRequestState {
    object Idle : LoginRequestState()
    object Loading : LoginRequestState()
    object Success : LoginRequestState()
    data class Error(val message: String) : LoginRequestState()
}