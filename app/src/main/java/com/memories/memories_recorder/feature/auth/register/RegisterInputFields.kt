package com.memories.memories_recorder.feature.auth.register

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.memories.memories_recorder.R
import com.memories.memories_recorder.feature.auth.ui.common.AuthPasswordField
import com.memories.memories_recorder.feature.auth.ui.common.AuthTextField
import com.memories.memories_recorder.ui.components.AppCheckBox
import com.memories.memories_recorder.ui.components.AppTextButton
import com.memories.memories_recorder.ui.theme.dimens

@Composable
fun RegisterInputFields(
    state: RegisterUiState,
    isAcceptedTerms: Boolean,
    onEmailChange: (String) -> Unit,
    onUserNameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onTogglePassword: () -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    onToggleConfirmPassword: () -> Unit,
    onCheckedChange: (Boolean) -> Unit,
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

        // User Field
        AuthTextField(
            value = state.username,
            onValueChange = onUserNameChange,
            placeholder = stringResource(R.string.username_placeholder),
            icon = R.drawable.ic_user,
            keyboardType = KeyboardType.Text
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

        // Confirm Password
        AuthPasswordField(
            value = state.confirmPassword,
            onValueChange = onConfirmPasswordChange ,
            placeholder = stringResource(R.string.confirm_password_placeholder),
            icon = R.drawable.ic_password,
            passwordVisible = state.confirmPasswordVisible,
            onToggleVisibility = onToggleConfirmPassword
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onCheckedChange(!isAcceptedTerms) },
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AppCheckBox(
                checked = isAcceptedTerms,
                onCheckedChange = onCheckedChange
            )

            Text(
                text = stringResource(R.string.accept),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 12.sp
                )
            )

            AppTextButton(
                text = stringResource(R.string.term_condition),
                onClick = {},
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                ),
            )

            Text(
                text = stringResource(R.string.and),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 12.sp
                )
            )

            AppTextButton(
                text = stringResource(R.string.privacy_policy),
                onClick = {},
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                ),
            )
        }
    }
}