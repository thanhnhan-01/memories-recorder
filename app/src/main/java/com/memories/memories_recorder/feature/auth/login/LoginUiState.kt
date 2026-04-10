package com.memories.memories_recorder.feature.auth.login

/**
 * UiState for Login Screen
 */

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val passwordVisible: Boolean = false,
    val isSuccess: Boolean = false
)