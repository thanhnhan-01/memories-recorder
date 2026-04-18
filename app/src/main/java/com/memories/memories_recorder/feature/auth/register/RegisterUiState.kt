package com.memories.memories_recorder.feature.auth.register

/**
 * UiState for Register Screen
 */

data class RegisterUiState(
    val email: String = "",
    val username: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val passwordVisible: Boolean = false,
    val confirmPasswordVisible: Boolean = false,
    val isAcceptedTerms: Boolean = false,
    val isSuccess: Boolean = false
)