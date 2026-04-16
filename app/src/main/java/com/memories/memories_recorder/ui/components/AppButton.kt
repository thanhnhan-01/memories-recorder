package com.memories.memories_recorder.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.memories.memories_recorder.ui.theme.dimens

@Composable
fun AppButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isLoading: Boolean = false,

    // Style
    shape: Shape ?= null,
    height: Float = 48f,
    fontWeight: FontWeight ?= null,
    fontSize: Float = 0f,

    // Colors
    backgroundColor: Color = Color.Unspecified,
    contentColor: Color = Color.Unspecified,

    // Content
    leadingIcon: @Composable (() -> Unit)? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
) {

    val finalFontSize = if (fontSize <= 0f) {
        MaterialTheme.dimens.textLg
    } else {
        fontSize.sp
    }

    val finalShape = shape ?: MaterialTheme.shapes.medium
    val finalHeight = height.dp
    val finalFontWeight = fontWeight ?: FontWeight.Medium

    val resBg = if (backgroundColor != Color.Unspecified) backgroundColor else MaterialTheme.colorScheme.primary
    val resContent = if (contentColor != Color.Unspecified) contentColor else MaterialTheme.colorScheme.onPrimary

    val resDisabledBg = resBg.copy(alpha = 0.4f)
    val resDisabledContent = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)


    Button(
        onClick = onClick,
        modifier = modifier.height(finalHeight),
        enabled = enabled && !isLoading,
        shape = finalShape,
        contentPadding = contentPadding,
        colors = ButtonDefaults.buttonColors(
            containerColor = resBg,
            contentColor = resContent,
            disabledContainerColor = resDisabledBg,
            disabledContentColor = resDisabledContent
        )
    ) {
        when {
            isLoading -> {
                CircularProgressIndicator(
                    color = resContent,
                    strokeWidth = 2.dp,
                    modifier = Modifier.size(18.dp)
                )
            }

            else -> {
                Row (
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    leadingIcon?.let {
                        it()
                        Spacer(modifier = Modifier.width(8.dp))
                    }

                    Text(
                        text = text,
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontWeight = finalFontWeight,
                            fontSize = finalFontSize,
                            color = resContent
                        )
                    )
                }
            }
        }
    }
}