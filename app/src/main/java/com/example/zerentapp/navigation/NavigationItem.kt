package com.example.zerentapp.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem (
    val title: String,
    val icon: Int,
    val screen: Screen,
    val iconSelected: Int
)