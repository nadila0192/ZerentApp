package com.example.zerentapp.navigation

sealed class Screen (val route : String) {
    data object Onboarding : Screen("onboarding")
    data object Home : Screen("home")
    data object Login : Screen("login")
    data object Register : Screen("register")
    data object VerifikasiEmail : Screen("verifemail")
    data object Request : Screen("request")
    data object Whishlist : Screen("whishlist")
    data object Order : Screen("order")
    data object About : Screen("about")
    data object ProfileSetting : Screen("profilesetting")
    data object Bantuan : Screen("bantuan")
    data object Toko : Screen("toko")
}