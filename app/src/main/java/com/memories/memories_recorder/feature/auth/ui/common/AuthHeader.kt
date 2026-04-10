package com.memories.memories_recorder.feature.auth.ui.common

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.memories.memories_recorder.R
import com.memories.memories_recorder.ui.theme.AppDimens
import com.memories.memories_recorder.ui.theme.dimens

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun AuthHeader() {
    val context = LocalContext.current
    val activity = context as? ComponentActivity

    val windowSizeClass = activity?.let { calculateWindowSizeClass(it) }

    val topSpacing = when (windowSizeClass?.heightSizeClass) {
        WindowHeightSizeClass.Compact -> MaterialTheme.dimens.space2xl
        WindowHeightSizeClass.Medium  -> MaterialTheme.dimens.space3xl
        else                          -> MaterialTheme.dimens.space5xl
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(MaterialTheme.dimens.space95xl))

        Image(
            painter = painterResource(id = R.drawable.logo_memories_app),
            contentDescription = "Memories App Logo",
//            modifier = Modifier.size(Dimens.logoSize)
        )

        Spacer(modifier = Modifier.height(MaterialTheme.dimens.space325xl))

    }
}