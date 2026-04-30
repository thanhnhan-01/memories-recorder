package com.memories.memories_recorder.feature.auth.login.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.memories.memories_recorder.R
import com.memories.memories_recorder.feature.auth.login.LoginAction
import com.memories.memories_recorder.feature.auth.login.LoginUiState
import com.memories.memories_recorder.feature.auth.ui.common.AuthPasswordField
import com.memories.memories_recorder.feature.auth.ui.common.AuthTextField
import com.memories.memories_recorder.ui.components.AppTextButton
import com.memories.memories_recorder.ui.theme.dimens

@Composable
fun LoginForm(
    state: LoginUiState,
    onAction: (LoginAction) -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.spaceMd),
        modifier = Modifier.fillMaxWidth()
    ) {
        // Email Field
        AuthTextField(
            value = state.email,
            onValueChange = { onAction(LoginAction.EmailChange(it)) },
            placeholder = stringResource(R.string.email_placeholder),
            icon = R.drawable.ic_email,
            keyboardType = KeyboardType.Email
        )

        // Password Field
        AuthPasswordField(
            value = state.password,
            onValueChange = { onAction(LoginAction.PasswordChange(it)) },
            placeholder = stringResource(R.string.password_placeholder),
            icon = R.drawable.ic_password,
            passwordVisible = state.passwordVisible,
            onToggleVisibility = { onAction(LoginAction.TogglePassword) }
        )

        AppTextButton(
            text = stringResource(R.string.forgot_password),
            onClick = { onAction(LoginAction.ForgotPasswordClick) },
            style = MaterialTheme.typography.bodyMedium.copy(fontSize = MaterialTheme.dimens.textMd),
        )
    }
}