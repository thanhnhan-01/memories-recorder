package com.memories.memories_recorder.feature.auth.presentation.login.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.memories.memories_recorder.feature.auth.presentation.login.LoginViewModel
import com.memories.memories_recorder.feature.auth.presentation.components.AuthHeader
import com.memories.memories_recorder.core.designsystem.theme.dimens


@Composable
fun LoginBody(
    viewModel: LoginViewModel = viewModel(),
) {
    val state = viewModel.uiState

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .imePadding()
            .padding(MaterialTheme.dimens.spaceXl),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item { AuthHeader() }

        item {
            LoginForm(
                state = state,
                onAction = viewModel::onAction
            )
        }
        item {
            LoginFooter(
                isLoading = state.isLoading,
                errorMessage = state.errorMessage,
                onAction = viewModel::onAction
            )
        }
    }
}