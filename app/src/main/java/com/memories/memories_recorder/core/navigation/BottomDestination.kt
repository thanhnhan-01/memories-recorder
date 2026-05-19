package com.memories.memories_recorder.core.navigation

import com.memories.memories_recorder.R

sealed class BottomDestination(
    val route: String,
    val icon: Int,
    val label: Int
) {
    object Home : BottomDestination(
        route = "home",
        icon = R.drawable.ic_home,
        label = R.string.label_home
    )

    object Add : BottomDestination(
        route = "add",
        icon = R.drawable.ic_add,
        label = R.string.label_add
    )

    object Profile : BottomDestination(
        route = "profile",
        icon = R.drawable.ic_profile,
        label = R.string.label_profile
    )
}