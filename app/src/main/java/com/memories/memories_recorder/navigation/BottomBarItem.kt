package com.memories.memories_recorder.navigation

import com.memories.memories_recorder.R

sealed class BottomBarItem(
    val route: String,
    val icon: Int,
    val label: Int
) {
    object Home : BottomBarItem(
        route = "home",
        icon = R.drawable.ic_home,
        label = R.string.label_home
    )

    object Add : BottomBarItem(
        route = "add",
        icon = R.drawable.ic_add,
        label = R.string.label_add
    )

    object Profile : BottomBarItem(
        route = "profile",
        icon = R.drawable.ic_profile,
        label = R.string.label_profile
    )
}