package com.memories.memories_recorder.ui.theme

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object Dimens {
    // Font sizes (use .sp for text – scales with user font settings)
    val textSizeSmall = 12.sp
    val textSizeMedium = 14.sp
    val textSizeLarge = 16.sp
    val textSizeTitle = 20.sp
    val textSizeHeading = 24.sp
    val textSizeDisplay = 32.sp

    // Spacing & padding (use .dp – does NOT scale with font size)
    val spacingTiny = 4.dp
    val spacingSmall = 8.dp      // Most common base unit (8dp grid)
    val spacingMedium = 16.dp     // Standard padding in Material
    val spacingLarge = 24.dp
    val spacingHuge = 32.dp

    // Icon / component sizes
    val iconSizeSmall = 16.dp
    val iconSizeMedium = 24.dp     // Standard icon button size
    val iconSizeLarge = 32.dp

    // Border radius (corner radius for buttons, cards, chips...)
    val cornerRadiusSmall = 8.dp
    val cornerRadiusMedium = 12.dp   // Common for buttons
    val cornerRadiusLarge = 16.dp   // Common for cards
    val cornerRadiusExtraLarge = 28.dp   // For large sheets or dialogs

    // Elevation / shadow (for Card, Surface elevation in Material 3)
    val elevationSmall = 2.dp
    val elevationMedium = 4.dp

    // Component heights
    val buttonHeight = 48.dp     // Material 3 recommended button height
    val cardHeightSmall = 80.dp
}
