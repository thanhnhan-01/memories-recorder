package com.memories.memories_recorder.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

private val LightColorScheme = lightColorScheme(
    primary = Primary,
    onPrimary = OnPrimary,

    background = Background,
    onBackground = OnBackground,

    surface = Surface,
    onSurface = OnSurface,
    surfaceVariant = SurfaceVariant,
    onSurfaceVariant = OnSurfaceVariant,

    surfaceContainer = BottomBarBackground ,

    error = Error
)

private val DarkColorScheme = darkColorScheme(
    primary = Primary,
)

val MaterialTheme.dimens: Dimens // MaterialTheme.dimens
    @Composable
    get() = LocalDimens.current

@Composable
fun MemoriesRecorderTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
//    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
//    val context = LocalContext.current

    val colorScheme = if(darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    val appDimens = LocalDimens.current

    CompositionLocalProvider(
        LocalDimens provides appDimens,
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            shapes = AppShapes,
            content = content
        )
    }
}