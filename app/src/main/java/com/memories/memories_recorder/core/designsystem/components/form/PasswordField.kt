package com.memories.memories_recorder.core.designsystem.components.form

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.memories.memories_recorder.R
import com.memories.memories_recorder.core.designsystem.theme.dimens

@Composable
fun PasswordField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    passwordVisible: Boolean,
    onToggleVisibility: () -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: @Composable (() -> Unit)? = null,
    contentPadding: PaddingValues = PaddingValues(
        horizontal = MaterialTheme.dimens.spaceXl,
        vertical = MaterialTheme.dimens.spaceMd
    ),
    placeholderSpacing: androidx.compose.ui.unit.Dp = MaterialTheme.dimens.spaceSm,
    placeholderTextStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    shape: Shape = RoundedCornerShape(MaterialTheme.dimens.radiusSm),
    containerColor: Color = MaterialTheme.colorScheme.surface,
) {
    BaseTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = placeholder,
        modifier = modifier,
        leadingIcon = leadingIcon,
        keyboardType = KeyboardType.Password,
        trailingIcon = {
            Crossfade(targetState = passwordVisible) { visible ->
                Box(
                    modifier = Modifier
                        .clickable { onToggleVisibility() }
                        .size(40.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(
                            if (visible) {
                                R.drawable.ic_visibility
                            } else {
                                R.drawable.ic_visibility_off
                            }
                        ),
                        contentDescription = null,
                        modifier = Modifier.size(MaterialTheme.dimens.iconMd)
                    )
                }
            }
        },
        visualTransformation = if (passwordVisible) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        contentPadding = contentPadding,
        placeholderSpacing = placeholderSpacing,
        placeholderTextStyle = placeholderTextStyle,
        shape = shape,
        containerColor = containerColor
    )
}