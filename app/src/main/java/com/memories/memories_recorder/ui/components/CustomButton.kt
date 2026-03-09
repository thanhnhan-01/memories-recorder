package com.memories.memories_recorder.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * A reusable, customizable button composable based on Material 3 Button.
 * Allows flexible styling such as color, shape, font size, icon, etc.
 *
 * @param text The text displayed on the button
 * @param onClick Callback invoked when the button is clicked
 * @param modifier Modifier for layout adjustments (padding, size, etc.)
 * @param enabled Whether the button is interactive or disabled
 * @param backgroundColor Background color of the button (defaults to theme primary)
 * @param contentColor Color of text and icons inside the button
 * @param disabledBackgroundColor Background color when button is disabled
 * @param shape Shape of the button (e.g., rounded corners)
 * @param fontSize Font size of the button text in sp
 * @param fontWeight Font weight of the button text
 * @param height Fixed height of the button (Material recommends 48.dp)
 * @param contentPadding Padding inside the button content
 * @param leadingIcon Optional icon displayed before the text
 */

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = MaterialTheme.colorScheme.onPrimary,
    disabledBackgroundColor: Color = MaterialTheme.colorScheme.primary.copy(alpha = 0.4f),
    shape: Shape = MaterialTheme.shapes.medium,
    fontSize: Float = 16f,
    fontWeight: FontWeight = FontWeight.Medium,
    height: Dp = 48.dp,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(height),
        enabled = enabled,
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor,
            disabledContainerColor = disabledBackgroundColor
        ),
        contentPadding = contentPadding,
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 2.dp)
    ) {
        if (leadingIcon != null) {
            leadingIcon()
        }
        Text(
            text = text,
            fontSize = fontSize.sp,
            fontWeight = fontWeight
        )
    }
}