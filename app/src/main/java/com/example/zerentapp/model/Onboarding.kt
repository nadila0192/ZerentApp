package com.example.zerentapp.model

import androidx.annotation.DrawableRes

data class Onboarding(
    val title : String,
    val description : String,
    @DrawableRes val image : Int
)
