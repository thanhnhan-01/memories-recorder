package com.memories.memories_recorder.feature.auth.login

/**
 * UiState for Login Screen
 */

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val passwordVisible: Boolean = false,
    val loginRequestState: LoginRequestState = LoginRequestState.Idle
)

sealed class LoginRequestState {
    object Idle : LoginRequestState()
    object Loading : LoginRequestState()
    object Success : LoginRequestState()
    data class Error(val message: String) : LoginRequestState()
}