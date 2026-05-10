package com.memories.memories_recorder.feature.auth.register.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.memories.memories_recorder.feature.auth.register.RegisterViewModel
import com.memories.memories_recorder.feature.auth.ui.common.AuthHeader
import com.memories.memories_recorder.ui.theme.dimens

@Composable
fun RegisterBody(
    viewModel: RegisterViewModel = viewModel(),
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
            RegisterForm(
                state = state,
                onAction = viewModel::onAction
            )
        }

        item {
            RegisterFooter(
                isLoading = state.isLoading,
                errorMessage = state.errorMessage,
                onAction = viewModel::onAction
            )
        }
    }
}