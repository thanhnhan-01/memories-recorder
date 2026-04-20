package com.memories.memories_recorder.feature.auth.register

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
fun RegisterContent(
    onLoginClick: () -> Unit,
) {
    var registerState by remember { mutableStateOf(RegisterUiState()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(MaterialTheme.dimens.spaceXl)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AuthHeader()

        RegisterInputFields(
            registerState = registerState,
            onEmailChange = { registerState = registerState.copy(email = it) },
            onUserNameChange = { registerState = registerState.copy(username = it) },
            onPasswordChange = { registerState = registerState.copy(password = it) },
            onConfirmPasswordChange = { registerState = registerState.copy(confirmPassword = it) },
            onPasswordVisibilityChange = {
                registerState = registerState.copy(passwordVisible = !registerState.passwordVisible)
            },
            onConfirmPasswordVisibilityChange = {
                registerState =
                    registerState.copy(confirmPasswordVisible = !registerState.confirmPasswordVisible)
            },
            onCheckedChange = { registerState = registerState.copy(isAcceptedTerms = it) }
        )

        RegisterSubmitSection(
            isLoading = registerState.isLoading,
            errorMessage = registerState.errorMessage,
            onSubmit = { },
            onModeChange = { },
            onLoginClick = onLoginClick,
        )
    }
}