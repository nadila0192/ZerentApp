package com.example.zerentapp.presentation.screen

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DensityMedium
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.zerentapp.R
import com.example.zerentapp.presentation.component.SearchBar
import com.example.zerentapp.ui.theme.mainn


@Composable
fun RequestBarangs(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(6.dp)
            .size(height = 40.dp, width = 300.dp),
        shape = MaterialTheme.shapes.small,
        colors = ButtonDefaults.buttonColors(mainn)
    ) {
        Text(text = "Request Barang",
            fontSize = 20.sp)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FiturResult(
    navController: NavController,
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.width(360.dp).clickable {navController.navigate("fail")},
                        contentAlignment = Alignment.Center
                    ) {
                        SearchBar(
                            navController = navController,
                            modifier = Modifier.padding(
                                16.dp
                            )
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF043C5B) // Change the color as needed
                )
            )
        }
    ) {
        Column(
            modifier = Modifier,
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 25.dp)
                    .padding(top = 80.dp),
            ) {
//                Icon(imageVector = Icons.Default.DensityMedium, contentDescription = null)
                Text(
                    text = "Filter Result",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding( start = 16.dp,)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxSize()
                    .padding(top = 50.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_5), contentDescription = null,
                    modifier = Modifier
                        .size(280.dp),
                    contentScale = ContentScale.FillBounds
                )
                Text(
                    modifier = Modifier
                        .padding(horizontal = 25.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 23.sp,
                    textAlign = TextAlign.Center,
                    text = "Maaf barang ini belum tersedia di sekitar anda"
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    modifier = Modifier,
                    fontSize = 17.sp,
                    text = "Silahkan ajukan barang yang anda butuhkan"
                )

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    RequestBarangs(onClick = { })
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FiturResultPreview(

){
    FiturResult(navController = NavController(LocalContext.current))
}