package com.memories.memories_recorder.feature.auth.login

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
fun LoginContent(
    viewModel: LoginViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    onForgotPasswordClick: () -> Unit,
    onRegisterClick: () -> Unit
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

        LoginInputFields(
            state = state ,
            onEmailChange = viewModel::onEmailChange ,
            onPasswordChange = viewModel::onPasswordChange,
            onTogglePassword = viewModel::onTogglePassword,
            onForgotPasswordClick = onForgotPasswordClick,
        )

        LoginSubmitSection(
            isLoading = state.isLoading ,
            errorMessage = state.errorMessage  ,
            onSubmit = viewModel::onSubmit,
            onRegisterClick = onRegisterClick,
        )
    }
}