package com.memories.memories_recorder.feature.auth.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.memories.memories_recorder.feature.auth.ui.common.AuthHeader
import com.memories.memories_recorder.ui.theme.dimens

@Composable
fun LoginContent(
    onForgotPasswordClick: () -> Unit,
    onRegisterClick: () -> Unit
) {
    var loginState by remember { mutableStateOf(LoginUiState()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(MaterialTheme.dimens.spaceXl)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AuthHeader()

        LoginInputFields(
            loginState = loginState,
            onEmailChange = { loginState = loginState.copy(email = it) },
            onPasswordChange = { loginState = loginState.copy(password = it) },
            onPasswordVisibilityChange = {
                loginState = loginState.copy(passwordVisible = !loginState.passwordVisible)
            },
            onForgotPasswordClick = onForgotPasswordClick,
        )

        LoginSubmitSection(
            isLoading = loginState.isLoading,
            errorMessage = loginState.errorMessage,
            onSubmit = { },
            onModeChange = { },
            onRegisterClick = onRegisterClick,
        )
    }
}