package com.example.zerentapp.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zerentapp.R
import com.example.zerentapp.presentation.component.ProductCard

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WishlistScreen() { // Use WishlistScreen for clarity
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.width(360.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        com.example.zerentapp.presentation.component.SearchBar(modifier = Modifier.padding(16.dp))
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF043C5B) // Change the color as needed
                )
            )
        }
    ) {
        // Main content with background image (replace with your image resource)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = it.calculateTopPadding() + 16.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
        ) {







            // Stacked product cards with rounded corners
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top
            ) {

                // Kategori
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(modifier = Modifier.padding(bottom = 0.dp)) {
                        Box(
                            modifier = Modifier
                                .clip(
                                    shape = RoundedCornerShape(
                                        topStart = 18.dp,
                                        topEnd = 18.dp,
                                        bottomEnd = 18.dp
                                    )
                                )
                                .height(40.dp)
                                .width(100.dp)
                                .weight(1f)
                                .background(color = Color(0xFF043C5B))
                                .border(1.dp, Color.White)
                        ) {
                            Text(
                                "Hobi", // Text content
                                modifier = Modifier
                                    .wrapContentSize() // Adjust size based on content
                                    .align(Alignment.Center),
                                color = Color.Yellow
                            )
                        }
                        Box(
                            modifier = Modifier
                                .clip(
                                    shape = RoundedCornerShape(
                                        topEnd = 18.dp,
                                        topStart = 18.dp,
                                        bottomStart = 18.dp
                                    )
                                )
                                .height(40.dp)
                                .width(100.dp)
                                .weight(1f)
                                .background(color = Color(0xFFE8E8E8))
                                .border(1.dp, Color.White)
                        ) {
                            Text(
                                "Kendaraan",
                                modifier = Modifier
                                    .wrapContentSize()
                                    .align(Alignment.Center),
                                color = Color.Black
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(modifier = Modifier.padding(top = 0.dp)) {
                        Box(
                            modifier = Modifier
                                .clip(
                                    shape = RoundedCornerShape(
                                        topStart = 18.dp,
                                        topEnd = 18.dp,
                                        bottomEnd = 18.dp
                                    )
                                )
                                .height(40.dp)
                                .width(100.dp)
                                .weight(1f)
                                .background(color = Color(0xFFE8E8E8))
                                .border(1.dp, Color.White)
                        ) {
                            Text(
                                "Elektronik",
                                modifier = Modifier
                                    .wrapContentSize() // Adjust size based on content
                                    .align(Alignment.Center),
                                color = Color.Black
                            )
                        }
                        Box(
                            modifier = Modifier
                                .clip(
                                    shape = RoundedCornerShape(
                                        topEnd = 18.dp,
                                        topStart = 18.dp,
                                        bottomStart = 18.dp
                                    )
                                )
                                .height(40.dp)
                                .width(100.dp)
                                .weight(1f)
                                .background(color = Color(0xFFE8E8E8))
                                .border(1.dp, Color.White)
                        ) {
                            Text(
                                "Peralatan",
                                modifier = Modifier
                                    .wrapContentSize() // Adjust size based on content
                                    .align(Alignment.Center),
                                color = Color.Black
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Row(modifier = Modifier.padding(top = 0.dp)) {
                        Box(
                            modifier = Modifier
                                .clip(
                                    shape = RoundedCornerShape(
                                        topStart = 18.dp,
                                        topEnd = 18.dp,
                                        bottomEnd = 18.dp
                                    )
                                )
                                .height(40.dp)
                                .width(100.dp)
                                .weight(1f)
                                .background(color = Color(0xFFE8E8E8))
                                .border(1.dp, Color.White)
                        ) {
                            Text(
                                "Kendaraan",
                                modifier = Modifier
                                    .wrapContentSize() // Adjust size based on content
                                    .align(Alignment.Center),
                                color = Color.Black
                            )
                        }
                        Box(
                            modifier = Modifier
                                .clip(
                                    shape = RoundedCornerShape(
                                        topEnd = 18.dp,
                                        topStart = 18.dp,
                                        bottomStart = 18.dp
                                    )
                                )
                                .height(40.dp)
                                .width(100.dp)
                                .weight(1f)
                                .background(color = Color(0xFFE8E8E8))
                                .border(1.dp, Color.White)
                        ) {
                            Text(
                                "Pakaian",
                                modifier = Modifier
                                    .wrapContentSize() // Adjust size based on content
                                    .align(Alignment.Center),
                                color = Color.Black
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ProductCard(
                        imageProduct = R.drawable.productcamera,
                        titleProduct = "Kamera EOS 3000D",
                        address = "Batam",
                        categoryProduct = "Hobi",
                        priceProduct ="125.000"
                    )
                    ProductCard(
                        imageProduct = R.drawable.productsepeda,
                        titleProduct = "Rental Sepeda MTB",
                        address = "Kawal",
                        categoryProduct = "Hobi",
                        priceProduct ="180.000"
                    )
                }

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun WishlistScreenPreview() {
    WishlistScreen()
}

