package com.example.zerentapp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.StarOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zerentapp.R

@Composable
fun ProductCard(
    imageProduct :Int,
    titleProduct :String,
    address :String,
    categoryProduct :String,
    priceProduct :String,
) {
    Card(
        modifier = Modifier
            .width(150.dp)
            .height(270.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top
            ) {
                Box(
                    modifier = Modifier
                        .height(110.dp)
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = imageProduct),
                        contentDescription = "Foto Produk",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )

                    IconButton(
                        onClick = { /* Tambahkan aksi yang ingin dilakukan saat ikon diklik */ },
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(8.dp) // Padding untuk memberikan jarak dari tepi
                            .size(24.dp) // Ukuran ikon
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Favorite,
                            contentDescription = "Love",
                            tint = Color.Red // Warna ikon
                        )
                    }
                }
            }

            Card(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .height(160.dp)
                    .offset(y = (-10).dp), // Offset to move the Card upwards
                //elevation = CardDefaults.cardElevation(5.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column(
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(
                        text = titleProduct,
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row {
                        Icon(
                            Icons.Default.LocationOn,
                            contentDescription = null,
                            modifier = Modifier.size(14.dp)
                        )
                        Text(
                            text = address,
                            fontSize = 12.sp,
                            overflow = TextOverflow.Ellipsis,
                            color = Color.Gray
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Button(
                        onClick = { /* Tambahkan aksi yang ingin dilakukan saat button diklik */ },
                        modifier = Modifier
                            .size(width = 50.dp, height = 20.dp),
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Cyan
                        ),
                        contentPadding = PaddingValues(0.dp) // Atur padding untuk memastikan teks berada di tengah
                    ) {
                        Text(
                            text = categoryProduct,
                            fontSize = 12.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxSize(), // Mengatur teks agar memenuhi button dan tetap center
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        repeat(5) {
                            Icon(
                                Icons.Rounded.StarOutline,
                                contentDescription = null,
                                tint = Color.Yellow,  // Warna untuk bintang kosong
                                modifier = Modifier.size(16.dp)
                            )
                        }

                        Text(
                            text = "Rp$priceProduct/Hari",
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                    }
                }
            }
        }
    }
}


@Preview (showBackground = true)
@Composable
private fun productCardPrev() {
    ProductCard(imageProduct = R.drawable.productcamera, titleProduct = "Kamera Canon 600D", address = "Batam", categoryProduct = "Hobi", priceProduct = "200.000")
}