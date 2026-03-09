package com.memories.memories_recorder.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes

/**
 * Custom Shapes for the app, following Material 3 guidelines.
 * Uses corner radii from Dimens for consistency.
 * Apply via MaterialTheme(shapes = Shapes).
 *
 * Standard Material 3 corner radii:
 * - extraSmall: 4dp (chips, small elements)
 * - small: 8dp
 * - medium: 12dp (buttons)
 * - large: 16dp (cards, elevated surfaces)
 * - extraLarge: 28dp (large sheets, dialogs)
 */

object Shape {
    val shapes = Shapes(
        extraSmall = RoundedCornerShape(Dimens.cornerRadiusSmall),       // 8.dp
        small = RoundedCornerShape(Dimens.cornerRadiusSmall),        // 8.dp (or customize)
        medium = RoundedCornerShape(Dimens.cornerRadiusMedium),       // 12.dp – common for buttons
        large = RoundedCornerShape(Dimens.cornerRadiusLarge),        // 16.dp – cards, surfaces
        extraLarge = RoundedCornerShape(Dimens.cornerRadiusExtraLarge)   // 28.dp – bottom sheets, modals
    )
}