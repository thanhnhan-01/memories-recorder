package com.memories.memories_recorder.ui.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.memories.memories_recorder.ui.theme.dimens

//@Composable
//fun AppButton(
//    text: String,
//    onClick: () -> Unit,
//    modifier: Modifier = Modifier,
//    enabled: Boolean = true,
//    backgroundColor: Color = MaterialTheme.colorScheme.primary,
//    contentColor: Color = MaterialTheme.colorScheme.onPrimary,
//    disabledBackgroundColor: Color = MaterialTheme.colorScheme.primary.copy(alpha = 0.4f),
//    shape: Shape = MaterialTheme.shapes.medium,
//    fontSize: TextUnit ?= null ,
//    fontWeight: FontWeight = FontWeight.Medium,
//    height: Dp = 48.dp,
//    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
//    leadingIcon: @Composable (() -> Unit)? = null,
//    style: TextStyle? = null
//) {
//    val resolvedFontSize = fontSize ?: MaterialTheme.dimens.textLg
//
//    Button(
//        onClick = onClick,
//        modifier = modifier.height(height),
//        enabled = enabled,
//        shape = shape,
//        colors = ButtonDefaults.buttonColors(
//            containerColor = backgroundColor,
//            contentColor = contentColor,
//            disabledContainerColor = disabledBackgroundColor
//        ),
//        contentPadding = contentPadding,
//        elevation = ButtonDefaults.buttonElevation(defaultElevation = 2.dp)
//    ) {
//        if (leadingIcon != null) {
//            leadingIcon()
//        }
//        Text(
//            text = text,
//            style = style ?: MaterialTheme.typography.labelLarge.copy(
//                fontWeight = fontWeight,
//                fontSize = resolvedFontSize
//            )
//        )
//    }
//}

//@Composable
//fun AppButton(
//    text: String,
//    onClick: () -> Unit,
//    modifier: Modifier = Modifier,
//    enabled: Boolean = true,
//    isLoading: Boolean = false,
//
//    // Style
//    shape: Shape = MaterialTheme.shapes.medium,
//    height: Dp = 48.dp,
//    fontWeight: FontWeight = FontWeight.Medium,
//    fontSize: TextUnit? = null,
//
//    // Colors
//    backgroundColor: Color ?= null,
//    contentColor: Color ?= null,
//    disabledContainerColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
//    disabledContentColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
//
//    // Content
//    leadingIcon: @Composable (() -> Unit)? = null,
//    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
//) {
//
//    val resolvedFontSize = fontSize ?: MaterialTheme.dimens.textLg
//
//    val resolvedBackground = backgroundColor ?: MaterialTheme.colorScheme.primary
//    val resolvedContent = contentColor ?: MaterialTheme.colorScheme.onPrimary
//    val resolvedDisabled = resolvedBackground.copy(alpha = 0.4f)
//
//    Log.d("DEBUG", "resolvedFontSize = $resolvedFontSize")
//    Log.d("DEBUG", "type = ${resolvedFontSize::class}")
//
//    Button(
//        onClick = onClick,
//        modifier = modifier.height(height),
//        enabled = enabled && !isLoading,
//        shape = shape,
//        contentPadding = contentPadding,
//        colors = ButtonDefaults.buttonColors(
//            containerColor = resolvedBackground,
//            contentColor = resolvedContent,
//            disabledContainerColor = resolvedDisabled,
//            disabledContentColor = disabledContentColor
//        )
//    ) {
//        when {
//            isLoading -> {
//                CircularProgressIndicator(
//                    color = resolvedContent,
//                    strokeWidth = 2.dp,
//                    modifier = Modifier.size(18.dp)
//                )
//            }
//
//            else -> {
//                Row (
//                    horizontalArrangement = Arrangement.Center,
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//
//                    leadingIcon?.let {
//                        it()
//                        Spacer(modifier = Modifier.width(8.dp))
//                    }
//
//                    Text(
//                        text = text,
//                        style = MaterialTheme.typography.labelLarge.copy(
//                            fontWeight = fontWeight,
//                            fontSize = resolvedFontSize
//                        )
//                    )
//                }
//            }
//        }
//    }
//}

@Composable
fun AppButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isLoading: Boolean = false,

    containerColor: Color = Color(0xFF1272CA),
    contentColor: Color = Color.White,
    shape: Shape = RoundedCornerShape(8.dp),
    height: Dp = 48.dp,
    fontWeight: FontWeight = FontWeight.Bold,
    fontSize: TextUnit = 16.sp,
    leadingIcon: @Composable (() -> Unit)? = null
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(height),
        enabled = enabled && !isLoading,
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = containerColor.copy(alpha = 0.4f),
            disabledContentColor = contentColor.copy(alpha = 0.6f)
        )
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                color = contentColor,
                strokeWidth = 2.dp,
                modifier = Modifier.size(18.dp)
            )
        } else {
            Row(
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
                        fontWeight = fontWeight,
                        fontSize = fontSize
                    )
                )
            }
        }
    }
}