package com.memories.memories_recorder.feature.auth.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.memories.memories_recorder.feature.auth.ui.common.AuthHeader
import com.memories.memories_recorder.ui.theme.dimens

@Composable
fun RegisterContent(
    viewModel: RegisterViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    onLoginClick: () -> Unit,
) {
    val state = viewModel.uiState
    val isLoading = state.registerRequestState is RegisterRequestState.Loading
    val errorMessage = (state.registerRequestState as? RegisterRequestState.Error)?.message

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(MaterialTheme.dimens.spaceXl)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AuthHeader()

        RegisterInputFields(
            email = state.email ,
            username = state.username,
            password = state.password,
            passwordVisible = state.passwordVisible,
            confirmPassword = state.confirmPassword,
            confirmPasswordVisible = state.confirmPasswordVisible,
            isAcceptedTerms = state.isAcceptedTerms ,
            onEmailChange = viewModel::onEmailChange,
            onUserNameChange = viewModel::onUsernameChange ,
            onPasswordChange = viewModel::onPasswordChange,
            onConfirmPasswordChange = viewModel::onConfirmPasswordChange,
            onPasswordVisibilityChange = viewModel::onTogglePassword ,
            onConfirmPasswordVisibilityChange = viewModel::onToggleConfirmPassword ,
            onCheckedChange = viewModel::onToggleTerms
        )

        RegisterSubmitSection(
            isLoading = isLoading,
            errorMessage = errorMessage,
            onSubmit = { },
            onModeChange = { },
            onLoginClick = onLoginClick,
        )
    }
}