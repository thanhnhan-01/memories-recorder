package com.memories.memories_recorder.feature.auth.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    var uiState by mutableStateOf(LoginUiState())
        private set

    private val _event = MutableSharedFlow<LoginEvent>()
    val event = _event.asSharedFlow()

    fun onAction(action: LoginAction) {
        when (action) {
            is LoginAction.EmailChange -> {
                uiState = uiState.copy(email = action.value)
            }

            is LoginAction.PasswordChange -> {
                uiState = uiState.copy(password = action.value)
            }

            LoginAction.TogglePassword -> {
                uiState = uiState.copy(
                    passwordVisible = !uiState.passwordVisible
                )
            }

            LoginAction.SubmitClicked -> onSubmit()

            LoginAction.RegisterClicked -> {
                emit(LoginEvent.NavigateToRegister)
            }

            LoginAction.ForgotPasswordClick -> {
                emit(LoginEvent.NavigateToForgotPassword)
            }
        }
    }

    private fun onSubmit() {
        viewModelScope.launch {
            uiState = uiState.copy(loginRequestState = LoginRequestState.Loading)
            delay(1500)
            uiState = uiState.copy(loginRequestState = LoginRequestState.Success)
            emit(LoginEvent.NavigateToHome)
        }
    }

    private fun emit(event: LoginEvent) {
        viewModelScope.launch {
            _event.emit(event)
        }
    }
}