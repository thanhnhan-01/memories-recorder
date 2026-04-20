package com.memories.memories_recorder.ui.utils

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * A wrapper composable that centers its content horizontally across all screens
 * and limits the maximum width on larger screens (tablet, foldable, desktop mode).
 *
 * @param modifier Modifier to be applied to the outer Box
 * @param content The composable content to be centered
 */

@Composable
fun AppWrapContent(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter // Center both horizontally and vertically
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .widthIn(max = 600.dp) // Value based on your design (e.g., 480.dp, 720.dp)
        ) {
            content()
        }
    }
}