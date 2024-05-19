package com.example.zerentapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Note
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.ShoppingCartCheckout
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route :String,
    val title: String,
    val icon : ImageVector
){
    object Home :BottomBarScreen(
        route = "home",
        title = "Home",
        icon =Icons.Default.Home
    )

    object Request :BottomBarScreen(
        route = "request",
        title = "Request",
        icon =Icons.Default.Note
    )

    object Whishlist :BottomBarScreen(
        route = "whishlist",
        title = "Whishlist",
        icon =Icons.Default.AddShoppingCart
    )
    object Order :BottomBarScreen(
        route = "order",
        title = "Order",
        icon =Icons.Default.ShoppingCartCheckout
    )
    object About :BottomBarScreen(
        route = "about",
        title = "About",
        icon =Icons.Default.Person
    )
}