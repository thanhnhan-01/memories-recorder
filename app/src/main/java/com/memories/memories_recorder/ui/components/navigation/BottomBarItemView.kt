package com.memories.memories_recorder.ui.components.navigation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.memories.memories_recorder.navigation.BottomBarItem
import com.memories.memories_recorder.ui.theme.dimens

@Composable
fun BottomBarItemView(
    item: BottomBarItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val contentColor by animateColorAsState(
        targetValue = if (isSelected) {
            MaterialTheme.colorScheme.onSurface
        } else {
            MaterialTheme.colorScheme.onSurfaceVariant
        },
        animationSpec = spring(),
        label = "bottom_bar_color"
    )

    val scale by animateFloatAsState(
        targetValue = if (isSelected) 1.05f else 1f,
        animationSpec = spring(),
        label = "bottom_bar_scale"
    )

    Column(
        modifier = Modifier
            .scale(scale)
            .clickable(
                interactionSource = remember {
                    MutableInteractionSource()
                },
                indication = null,
                onClick = onClick
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            painter = painterResource(item.icon),
            contentDescription = "Items",
            tint = contentColor
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = stringResource(item.label),
            style = MaterialTheme.typography.bodySmall.copy(
                fontSize = MaterialTheme.dimens.textSm,
                fontWeight = FontWeight.Bold,
                color = contentColor
            )
        )
    }
}