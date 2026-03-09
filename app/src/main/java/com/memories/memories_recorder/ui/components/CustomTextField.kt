package com.memories.memories_recorder.ui.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.sp

/**
 * A reusable, customizable OutlinedTextField composable.
 * Supports custom colors, font size, keyboard type, icons, error state, etc.
 *
 * @param value Current text value of the field
 * @param onValueChange Callback when text changes
 * @param modifier Modifier for layout (width, padding, etc.)
 * @param label Optional label text shown above the field
 * @param placeholder Optional placeholder text when field is empty
 * @param textColor Color of the input text
 * @param labelColor Color of the label text
 * @param focusedBorderColor Color of the border when field is focused
 * @param fontSize Font size of the input text in sp
 * @param singleLine Whether the field allows multiple lines (default: single line)
 * @param keyboardType Type of keyboard to show (text, email, password, number...)
 * @param visualTransformation Transformation for input (e.g., password masking)
 * @param trailingIcon Optional icon or button at the end of the field
 * @param isError Whether to show error state (red border)
 * @param supportingText Optional helper/error text below the field
 */

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    placeholder: String? = null,
    textColor: Color = MaterialTheme.colorScheme.onSurface,
    labelColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
    focusedBorderColor: Color = MaterialTheme.colorScheme.primary,
    fontSize: Float = 16f,
    singleLine: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Text,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    supportingText: String? = null
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        label = label?.let { { Text(it, color = labelColor) } },
        placeholder = placeholder?.let { { Text(it) } },
        textStyle = TextStyle(
            color = textColor,
            fontSize = fontSize.sp
        ),
        singleLine = singleLine,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        visualTransformation = visualTransformation,
        trailingIcon = trailingIcon,
        isError = isError,
        supportingText = supportingText?.let { { Text(it) } },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = focusedBorderColor,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.outline
        )
    )
}