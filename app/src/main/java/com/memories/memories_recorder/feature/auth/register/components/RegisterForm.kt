package com.memories.memories_recorder.feature.auth.register.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.memories.memories_recorder.R
import com.memories.memories_recorder.feature.auth.register.RegisterAction
import com.memories.memories_recorder.feature.auth.register.RegisterUiState
import com.memories.memories_recorder.feature.auth.ui.common.AuthPasswordField
import com.memories.memories_recorder.feature.auth.ui.common.AuthTextField
import com.memories.memories_recorder.ui.theme.dimens

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
            keyboardType = KeyboardType.Email
        )

        // User Field
        AuthTextField(
            value = state.username,
            onValueChange = { onAction(RegisterAction.UsernameChanged(it)) },
            placeholder = stringResource(R.string.username_placeholder),
            icon = R.drawable.ic_user,
            keyboardType = KeyboardType.Text
        )

        // Password Field
        AuthPasswordField(
            value = state.password,
            onValueChange = { onAction(RegisterAction.PasswordChanged(it)) },
            placeholder = stringResource(R.string.password_placeholder),
            icon = R.drawable.ic_password,
            passwordVisible = state.passwordVisible,
            onToggleVisibility = { onAction(RegisterAction.TogglePassword) }
        )

        // Confirm Password
        AuthPasswordField(
            value = state.confirmPassword,
            onValueChange = { onAction(RegisterAction.ConfirmPasswordChanged(it)) },
            placeholder = stringResource(R.string.confirm_password_placeholder),
            icon = R.drawable.ic_password,
            passwordVisible = state.confirmPasswordVisible,
            onToggleVisibility = { onAction(RegisterAction.ToggleConfirmPassword) }
        )

        TermsAndPolicySection(
            isAccepted = state.isAcceptedTerms,
            onCheckedChange = {
                onAction(RegisterAction.TermsCheckedChanged(it))
            }
        )
    }
}