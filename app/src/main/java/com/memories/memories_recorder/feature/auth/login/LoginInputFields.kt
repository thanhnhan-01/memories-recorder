package com.memories.memories_recorder.feature.auth.login

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.memories.memories_recorder.R
import com.memories.memories_recorder.ui.components.AppTextButton
import com.memories.memories_recorder.ui.components.AppTextField
import com.memories.memories_recorder.ui.theme.AppDimens
import com.memories.memories_recorder.ui.theme.dimens

@Composable
fun LoginInputFields(
    loginState: LoginUiState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onPasswordVisibilityChange: () -> Unit,
    onForgotPasswordClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.spaceMd),
        modifier = Modifier.fillMaxWidth()
    ) {
        // Email Field
        AppTextField(
            value = loginState.email,
            onValueChange = onEmailChange,
            placeholder = "Enter your email",
            keyboardType = KeyboardType.Email,
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_email),
                    contentDescription = "Email Icon",
                    modifier = Modifier.size(MaterialTheme.dimens.iconMd)
                )
            },
            contentPadding = PaddingValues(
                horizontal = MaterialTheme.dimens.spaceXl,
                vertical = 12.dp
            ),
            placeholderSpacing = MaterialTheme.dimens.spaceSm,
            placeholderTextStyle = MaterialTheme.typography.bodyMedium.copy(fontSize = MaterialTheme.dimens.textLg),
            shape = RoundedCornerShape(MaterialTheme.dimens.radiusSm),
            containerColor = MaterialTheme.colorScheme.surface
        )

        // Password Field
        AppTextField(
            value = loginState.password,
            onValueChange = onPasswordChange,
            placeholder = "Enter your password",
            keyboardType = KeyboardType.Password,
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_password),
                    contentDescription = "Password Icon",
                    modifier = Modifier.size(MaterialTheme.dimens.iconMd)
                )
            },
            trailingIcon = {
                Crossfade(targetState = loginState.passwordVisible) { visible ->
                    Box(
                        modifier = Modifier
                            .clickable { onPasswordVisibilityChange() }
                            .size(40.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(
                                if (visible) R.drawable.ic_visibility
                                else R.drawable.ic_visibility_off
                            ),
                            contentDescription = null,
                            modifier = Modifier.size(MaterialTheme.dimens.iconMd) // 24
                        )
                    }
                }
            },
            visualTransformation = if (loginState.passwordVisible)
                VisualTransformation.None
            else
                PasswordVisualTransformation(),
            contentPadding = PaddingValues(
                horizontal = MaterialTheme.dimens.spaceXl,
                vertical = MaterialTheme.dimens.spaceMd
            ),
            placeholderSpacing = MaterialTheme.dimens.spaceSm,
            placeholderTextStyle = MaterialTheme.typography.bodyMedium.copy(fontSize = MaterialTheme.dimens.textLg),
            shape = RoundedCornerShape(MaterialTheme.dimens.radiusSm),
            containerColor = MaterialTheme.colorScheme.surface
        )

        AppTextButton(
            text = "Forgot Password?",
            onClick = onForgotPasswordClick ,
            style = MaterialTheme.typography.bodyMedium.copy(fontSize = MaterialTheme.dimens.textMd),
        )
    }
}