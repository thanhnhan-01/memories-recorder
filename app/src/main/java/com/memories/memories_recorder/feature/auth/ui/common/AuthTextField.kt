package com.memories.memories_recorder.feature.auth.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.memories.memories_recorder.ui.components.AppTextField
import com.memories.memories_recorder.ui.theme.dimens

@Composable
fun AuthTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    icon: Int,
    keyboardType: KeyboardType = KeyboardType.Text,
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
            keyboardType = keyboardType,
            leadingIcon = {
                Icon(
                    painter = painterResource(icon),
                    contentDescription = null,
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

//        if (error != null) {
//            Text(
//                text = error,
//                color = MaterialTheme.colorScheme.error,
//                style = MaterialTheme.typography.bodySmall
//            )
//        }
    }
}