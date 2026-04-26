package com.memories.memories_recorder.feature.auth.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.memories.memories_recorder.R
import com.memories.memories_recorder.feature.auth.ui.common.AuthPasswordField
import com.memories.memories_recorder.feature.auth.ui.common.AuthTextField
import com.memories.memories_recorder.ui.components.AppTextButton
import com.memories.memories_recorder.ui.theme.dimens

@Composable
fun LoginInputFields(
    state: LoginUiState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onTogglePassword: () -> Unit,
    onForgotPasswordClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.spaceMd),
        modifier = Modifier.fillMaxWidth()
    ) {
        // Email Field
        AuthTextField(
            value = state.email,
            onValueChange = onEmailChange,
            placeholder = stringResource(R.string.email_placeholder),
            icon = R.drawable.ic_email,
            keyboardType = KeyboardType.Email
        )

        // Password Field
        AuthPasswordField(
            value = state.password,
            onValueChange = onPasswordChange,
            placeholder = stringResource(R.string.password_placeholder),
            icon = R.drawable.ic_password,
            passwordVisible = state.passwordVisible,
            onToggleVisibility = onTogglePassword
        )

        AppTextButton(
            text = stringResource(R.string.forgot_password),
            onClick = onForgotPasswordClick ,
            style = MaterialTheme.typography.bodyMedium.copy(fontSize = MaterialTheme.dimens.textMd),
        )
    }
}