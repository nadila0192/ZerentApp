package com.example.zerentapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.zerentapp.presentation.screen.About
import com.example.zerentapp.presentation.screen.Order
import com.example.zerentapp.presentation.screen.RequestScreen
import com.example.zerentapp.presentation.screen.RequestScreen
import com.example.zerentapp.presentation.screen.Whishlist
import com.example.zerentapp.presentation.screen.home

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            home()
        }
        composable(route = BottomBarScreen.Request.route) {
            RequestScreen()
        }
        composable(route = BottomBarScreen.Whishlist.route) {
            Whishlist()
        }
        composable(route = BottomBarScreen.Order.route) {
            Order()
        }
        composable(route = BottomBarScreen.About.route) {
            About()
        }
    }
}