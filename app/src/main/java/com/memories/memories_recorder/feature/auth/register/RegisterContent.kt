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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(MaterialTheme.dimens.spaceXl)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AuthHeader()

        RegisterInputFields(
            state = state,
            isAcceptedTerms = state.isAcceptedTerms,
            onEmailChange = viewModel::onEmailChange,
            onUserNameChange = viewModel::onUsernameChange,
            onPasswordChange = viewModel::onPasswordChange,
            onConfirmPasswordChange = viewModel::onConfirmPasswordChange,
            onTogglePassword = viewModel::onTogglePassword,
            onToggleConfirmPassword = viewModel::onToggleConfirmPassword,
            onCheckedChange = viewModel::onToggleTerms
        )

        RegisterSubmitSection(
            isLoading = state.isLoading,
            errorMessage = state.errorMessage,
            onSubmit = viewModel::onSubmit,
            onLoginClick = onLoginClick,
        )
    }
}