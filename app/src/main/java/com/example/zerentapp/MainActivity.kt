package com.example.zerentapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.zerentapp.ui.theme.ZerentAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            ZerentAppTheme {

//                val navController = rememberNavController()
//                NavHost(navController = navController, startDestination = "onboarding") {
//                    composable("onboarding") { OnBoardingScreen(navController = navController) }
//                    composable("home") { HomeScreen(navController) }


                //OnBoardingScreen()

                ZerentApp()

            }
        }
    }
}

