package com.example.zerentapp.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.zerentapp.R
import com.example.zerentapp.presentation.component.AlertDialogPosting

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PostingProductScreen(navController: NavController,
                         modifier: Modifier = Modifier) {

    var showDialog by remember {
        mutableStateOf(false)
    }

    if (showDialog){
        AlertDialogPosting(onDismiss = { showDialog = false })
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Icon(imageVector = Icons.Default.ArrowBackIos,
                            contentDescription = null,
                            modifier = Modifier.size(28.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF043C5B) // Change the color as needed
                )
            )
        }
    ) {

        LazyColumn(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            item {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 80.dp)
                ) {
                    Box(modifier = Modifier) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_tambahfotoproduct),
                            contentDescription = null,
                            modifier = Modifier
                                .width(360.dp)
                                .height(200.dp)
                        )
                    }
                }
            }

            item {
                var namaBarang by remember { mutableStateOf("") }
                TextField(
                    value = namaBarang,
                    onValueChange = { namaBarang = it },
                    modifier = modifier
                        .border(
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .background(Color.White, RoundedCornerShape(4.dp))
                        .width(320.dp)
                        .height(30.dp)
                        .padding(horizontal = 0.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    label = { Text(text = "nama") }
                )
            }

            item {
                var hargaSewa by remember { mutableStateOf("") }
                TextField(
                    value = hargaSewa,
                    onValueChange = { hargaSewa = it },
                    modifier = modifier
                        .border(
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .background(Color.White, RoundedCornerShape(4.dp))
                        .width(320.dp)
                        .height(30.dp)
                        .padding(horizontal = 0.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    label = { Text(text = "Harga Sewa") }
                )
            }

            item {
                var deposit by remember { mutableStateOf("") }
                TextField(
                    value = deposit,
                    onValueChange = { deposit = it },
                    modifier = modifier
                        .border(
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .background(Color.White, RoundedCornerShape(4.dp))
                        .width(320.dp)
                        .height(30.dp)
                        .padding(horizontal = 0.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    label = { Text(text = "Deposit") }
                )
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.width(17.dp))
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null,
                        modifier = Modifier.size(15.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "Tambahkan Lokasi",
                        fontSize = 13.sp
                    )
                }
            }

            item {
                Spacer(modifier = Modifier.height(180.dp))
            }

            item {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = { showDialog = true },
                        modifier = Modifier
                            .width(300.dp)
                            .border(
                                width = 1.dp,
                                color = Color(0xff043C5B),
                                shape = RoundedCornerShape(10.dp)
                            ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White
                        ),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            text = "SIMPAN",
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun PostingProductPrev() {
    PostingProductScreen(navController = rememberNavController())
}
