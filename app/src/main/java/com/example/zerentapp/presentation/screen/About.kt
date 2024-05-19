package com.example.zerentapp.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.zerentapp.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun About() {
    Scaffold {
       Column {
           Row {
               Icon(painter = painterResource(id = R.drawable.lucas), contentDescription = null)
           }
       } 
    }
}