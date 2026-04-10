package com.memories.memories_recorder.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Dimens(
    val textSm: TextUnit,
    val textMd: TextUnit,
    val textLg: TextUnit,
    val textXl: TextUnit,

    val spaceXs: Dp,
    val spaceSm: Dp,
    val spaceMd: Dp,
    val spaceLg: Dp,
    val space2lg: Dp,
    val spaceXl: Dp,
    val space2xl: Dp,
    val space3xl: Dp,
    val space325xl: Dp,
    val space5xl: Dp,
    val space95xl: Dp,

    val radiusSm: Dp,
    val radiusMd: Dp,
    val radiusLg: Dp,

    val iconSm: Dp,
    val iconMd: Dp,
    val iconLg: Dp,

    val buttonHeight: Dp,
    val screenPadding: Dp
)

val LocalDimens = compositionLocalOf {
    Dimens(
        textSm = 14.sp,
        textMd = 16.sp,
        textLg = 18.sp,
        textXl = 24.sp,

        spaceXs = 4.dp,  // 4
        spaceSm = 8.dp,   // 8
        spaceMd = 12.dp, // 12
        spaceLg = 16.dp, // 16
        space2lg = 18.dp,
        spaceXl = 24.dp,  // 24
        space2xl = 32.dp, // 32
        space3xl = 48.dp,
        space325xl = 52.dp,
        space5xl = 80.dp,
        space95xl = 152.dp,

        radiusSm = 8.dp,
        radiusMd = 12.dp,
        radiusLg = 16.dp,

        iconSm = 16.dp,
        iconMd = 24.dp,
        iconLg = 32.dp,

        buttonHeight = 48.dp,
        screenPadding = 24.dp
    )
}
