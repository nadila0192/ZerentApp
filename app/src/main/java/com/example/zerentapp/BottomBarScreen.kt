package com.example.zerentapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Note
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.ShoppingCartCheckout
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource

sealed class BottomBarScreen(
    val route :String,
    val title: String,
    val icon : Int,
    val iconSelected: Int
){
    object Home :BottomBarScreen(
        route = "home",
        title = "Home",
        icon =  R.drawable.ic_home,
        iconSelected =  R.drawable.ic_selected_home
    )

    object Request :BottomBarScreen(
        route = "request",
        title = "Request",
        icon = R.drawable.ic_request,
        iconSelected =  R.drawable.ic_selected_request
    )

    object Whishlist :BottomBarScreen(
        route = "whishlist",
        title = "Whishlist",
        icon =R.drawable.ic_whishlist,
        iconSelected =  R.drawable.ic_selected_whishlist
    )
    object Order :BottomBarScreen(
        route = "order",
        title = "Order",
        icon =R.drawable.ic_order,
        iconSelected =  R.drawable.ic_selected_order
    )
    object About :BottomBarScreen(
        route = "about",
        title = "About",
        icon =R.drawable.ic_profile,
        iconSelected =  R.drawable.ic_selected_profile
    )
}