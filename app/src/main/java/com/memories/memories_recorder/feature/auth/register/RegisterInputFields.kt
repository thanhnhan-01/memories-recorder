package com.memories.memories_recorder.feature.auth.register

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.memories.memories_recorder.R
import com.memories.memories_recorder.ui.components.AppCheckBox
import com.memories.memories_recorder.ui.components.AppTextButton
import com.memories.memories_recorder.ui.components.AppTextField
import com.memories.memories_recorder.ui.theme.dimens

@Composable
fun RegisterInputFields(
    registerState: RegisterUiState,
    onEmailChange: (String) -> Unit,
    onUserNameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onPasswordVisibilityChange: () -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    onConfirmPasswordVisibilityChange: () -> Unit,
    onCheckedChange: (Boolean) -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.spaceMd),
        modifier = Modifier.fillMaxWidth()
    ) {
        // Email Field
        AppTextField(
            value = registerState.email,
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

        // User Field
        AppTextField(
            value = registerState.username,
            onValueChange = onUserNameChange,
            placeholder = "Enter your username",
            keyboardType = KeyboardType.Text,
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_user),
                    contentDescription = "Username Icon",
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
            value = registerState.password,
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
                Crossfade(targetState = registerState.passwordVisible) { visible ->
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
            visualTransformation = if (registerState.passwordVisible)
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

        // Confirm Password
        AppTextField(
            value = registerState.confirmPassword,
            onValueChange = onConfirmPasswordChange,
            placeholder = "Confirm your password",
            keyboardType = KeyboardType.Password,
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_password),
                    contentDescription = "Password Icon",
                    modifier = Modifier.size(MaterialTheme.dimens.iconMd)
                )
            },
            trailingIcon = {
                Crossfade(targetState = registerState.confirmPasswordVisible) { visible ->
                    Box(
                        modifier = Modifier
                            .clickable { onConfirmPasswordVisibilityChange() }
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
            visualTransformation = if (registerState.confirmPasswordVisible)
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

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onCheckedChange(!registerState.isAcceptedTerms) },
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AppCheckBox(
                checked = registerState.isAcceptedTerms,
                onCheckedChange = onCheckedChange
            )

            Text(
                text = "I accept",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 12.sp
                )
            )

            AppTextButton(
                text = "Terms and Condition",
                onClick = {},
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                ),
            )

            Text(
                text = "and",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 12.sp
                )
            )

            AppTextButton(
                text = "Privacy Policy",
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