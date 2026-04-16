package com.memories.memories_recorder.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = Primary,
    onPrimary = OnPrimary,

    background = Background,
    surface = Surface,
    surfaceVariant = SurfaceVariant,

    onBackground = OnBackground,
    onSurface = OnSurface,
    onSurfaceVariant = OnSurfaceVariant,

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