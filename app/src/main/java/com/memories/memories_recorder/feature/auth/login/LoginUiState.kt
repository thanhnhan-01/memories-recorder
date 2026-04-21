package com.memories.memories_recorder.feature.auth.login

/**
 * UiState for Login Screen
 */

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val passwordVisible: Boolean = false,
    val requestState: RequestState = RequestState.Idle
)

sealed class RequestState {
    object Idle : RequestState()
    object Loading : RequestState()
    object Success : RequestState()
    data class Error(val message: String) : RequestState()
}