package com.memories.memories_recorder.feature.auth.presentation.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.memories.memories_recorder.feature.auth.domain.validation.RegisterValidator
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {
    var uiState by mutableStateOf(RegisterUiState())
        private set

    private val _event = MutableSharedFlow<RegisterEvent>()
    val event = _event.asSharedFlow()

    fun onAction(action: RegisterAction) {
        when (action) {
            is RegisterAction.EmailChanged -> {
                uiState = uiState.copy(email = action.value, emailError = null)
            }

            is RegisterAction.UsernameChanged -> {
                uiState = uiState.copy(username = action.value, usernameError = null)
            }

            is RegisterAction.PasswordChanged -> {
                uiState = uiState.copy(
                    password = action.value,
                    passwordError = null,
                    confirmPasswordError = null
                )
            }

            is RegisterAction.ConfirmPasswordChanged -> {
                uiState = uiState.copy(confirmPassword = action.value, confirmPasswordError = null)
            }

            RegisterAction.TogglePassword -> {
                uiState = uiState.copy(
                    passwordVisible = !uiState.passwordVisible
                )
            }

            RegisterAction.ToggleConfirmPassword -> {
                uiState = uiState.copy(
                    confirmPasswordVisible = !uiState.confirmPasswordVisible
                )
            }

            is RegisterAction.TermsCheckedChanged -> {
                uiState = uiState.copy(
                    isAcceptedTerms = action.checked,
                    termsError = if(action.checked) null else uiState.termsError
                )
            }

            RegisterAction.SubmitClicked -> onSubmit()

            RegisterAction.LoginClicked -> {
                emit(RegisterEvent.NavigateToLogin)
            }
        }
    }

    private fun onSubmit() {
        val usernameError =
            RegisterValidator.validateUsername(uiState.username)

        val emailError =
            RegisterValidator.validateEmail(uiState.email)

        val passwordError =
            RegisterValidator.validatePassword(uiState.password)

        val confirmPasswordError =
            RegisterValidator.validateConfirmPassword(
                password = uiState.password,
                confirmPassword = uiState.confirmPassword
            )

        val termsError =
            if (uiState.isAcceptedTerms) {
                null
            } else {
                "You must accept the Terms and Conditions."
            }

        // Update validation errors before submitting.
        uiState = uiState.copy(
            usernameError = usernameError,
            emailError = emailError,
            passwordError = passwordError,
            confirmPasswordError = confirmPasswordError,
            termsError = termsError
        )

        // Stop when any field is invalid.
        if (
            usernameError != null ||
            emailError != null ||
            passwordError != null ||
            confirmPasswordError != null ||
            termsError != null
        ) {
            return
        }

        // Submit only after all validations pass.
        viewModelScope.launch {
            uiState = uiState.copy(
                registerRequestState = RegisterRequestState.Loading
            )

            // Temporary simulation. Replace with the Auth API request.
            delay(1500)

            uiState = uiState.copy(
                registerRequestState = RegisterRequestState.Success
            )

            emit(RegisterEvent.NavigateToHome)
        }
    }

    private fun emit(event: RegisterEvent) {
        viewModelScope.launch {
            _event.emit(event)
        }
    }
}