package com.memories.memories_recorder.feature.auth.presentation.register.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.memories.memories_recorder.R
import com.memories.memories_recorder.feature.auth.presentation.register.RegisterAction
import com.memories.memories_recorder.feature.auth.presentation.register.RegisterUiState
import com.memories.memories_recorder.feature.auth.presentation.components.AuthPasswordField
import com.memories.memories_recorder.feature.auth.presentation.components.AuthTextField

import com.memories.memories_recorder.core.designsystem.theme.dimens

@Composable
fun RegisterForm(
    state: RegisterUiState,
    onAction: (RegisterAction) -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.spaceMd),
        modifier = Modifier.fillMaxWidth()
    ) {
        // Email Field
        AuthTextField(
            value = state.email,
            onValueChange = { onAction(RegisterAction.EmailChanged(it)) },
            placeholder = stringResource(R.string.email_placeholder),
            icon = R.drawable.ic_email,
            keyboardType = KeyboardType.Email,
            error = state.emailError
        )

        // Username Field
        AuthTextField(
            value = state.username,
            onValueChange = { onAction(RegisterAction.UsernameChanged(it)) },
            placeholder = stringResource(R.string.username_placeholder),
            icon = R.drawable.ic_user,
            keyboardType = KeyboardType.Text,
            error = state.usernameError
        )

        // Password Field
        AuthPasswordField(
            value = state.password,
            onValueChange = { onAction(RegisterAction.PasswordChanged(it)) },
            placeholder = stringResource(R.string.password_placeholder),
            icon = R.drawable.ic_password,
            passwordVisible = state.passwordVisible,
            onToggleVisibility = { onAction(RegisterAction.TogglePassword) },
            error = state.passwordError
        )

        // Confirm Password
        AuthPasswordField(
            value = state.confirmPassword,
            onValueChange = { onAction(RegisterAction.ConfirmPasswordChanged(it)) },
            placeholder = stringResource(R.string.confirm_password_placeholder),
            icon = R.drawable.ic_password,
            passwordVisible = state.confirmPasswordVisible,
            onToggleVisibility = { onAction(RegisterAction.ToggleConfirmPassword) },
            error = state.confirmPasswordError
        )

        TermsAndPolicySection(
            isAccepted = state.isAcceptedTerms,
            onCheckedChange = {
                onAction(RegisterAction.TermsCheckedChanged(it))
            }
        )

        // Terms validation error
        state.termsError?.let { error ->
            androidx.compose.material3.Text(
                text = error,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}