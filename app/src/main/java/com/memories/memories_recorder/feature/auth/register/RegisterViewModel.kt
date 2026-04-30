package com.memories.memories_recorder.feature.auth.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
                uiState = uiState.copy(email = action.value)
            }

            is RegisterAction.UsernameChanged -> {
                uiState = uiState.copy(username = action.value)
            }

            is RegisterAction.PasswordChanged -> {
                uiState = uiState.copy(password = action.value)
            }

            is RegisterAction.ConfirmPasswordChanged -> {
                uiState = uiState.copy(confirmPassword = action.value)
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
                uiState = uiState.copy(isAcceptedTerms = action.checked)
            }

            RegisterAction.SubmitClicked -> onSubmit()

            RegisterAction.LoginClicked -> {
                emit(RegisterEvent.NavigateToLogin)
            }
        }
    }

    private fun onSubmit() {
        viewModelScope.launch {
            uiState = uiState.copy(registerRequestState = RegisterRequestState.Loading)
            delay(1500)
            uiState = uiState.copy(registerRequestState = RegisterRequestState.Success)
            emit(RegisterEvent.NavigateToHome)
        }
    }

    private fun emit(event: RegisterEvent) {
        viewModelScope.launch {
            _event.emit(event)
        }
    }
}