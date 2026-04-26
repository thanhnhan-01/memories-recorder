package com.memories.memories_recorder.feature.auth.ui.common

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.memories.memories_recorder.R
import com.memories.memories_recorder.ui.components.AppTextField
import com.memories.memories_recorder.ui.theme.dimens

@Composable
fun AuthPasswordField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    icon: Int,
    passwordVisible: Boolean,
    onToggleVisibility: () -> Unit,
    error: String? = null
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.spaceSm),
        modifier = Modifier.fillMaxWidth()
    ) {
        AppTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = placeholder,
            leadingIcon = {
                Icon(
                    painter = painterResource(icon),
                    contentDescription = null,
                    modifier = Modifier.size(MaterialTheme.dimens.iconMd)
                )
            },
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
                                if (visible) R.drawable.ic_visibility
                                else R.drawable.ic_visibility_off
                            ),
                            contentDescription = null,
                            modifier = Modifier.size(MaterialTheme.dimens.iconMd)
                        )
                    }
                }
            },
            visualTransformation = if (passwordVisible)
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

//        if (error != null) {
//            Text(
//                text = error,
//                color = MaterialTheme.colorScheme.error,
//                style = MaterialTheme.typography.bodySmall
//            )
//        }
    }
}