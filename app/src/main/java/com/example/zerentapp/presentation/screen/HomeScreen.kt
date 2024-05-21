package com.example.zerentapp.presentation.screen

import android.annotation.SuppressLint
import android.provider.CalendarContract
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.StarOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.zerentapp.R
import com.example.zerentapp.presentation.component.SearchBar

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Scaffold {
        LazyColumn(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize()
        ) {
            item {
                Row {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        Modifier.size(50.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Selamat Datang, MJ!",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(top = 10.dp)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                SearchBar()

                Spacer(modifier = Modifier.height(20.dp))

                // Banner promo
                LazyRow(modifier = Modifier.fillMaxWidth()) {
                    items(3) {
                        Card(
                            modifier
                                .height(100.dp)
                                .width(350.dp)
                                .fillMaxWidth()
                                .padding(5.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.bannerpromohome),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize(1f),
                                contentScale = ContentScale.FillWidth
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Kategori",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "more",
                        textDecoration = TextDecoration.Underline
                    )
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }

                // Kategori
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(modifier = Modifier.padding(bottom = 0.dp)) {
                        Box(
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(topStart = 18.dp))
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
                                color = Color.White
                            )
                        }
                        Box(
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(topEnd = 18.dp))
                                .height(40.dp)
                                .width(100.dp)
                                .weight(1f)
                                .background(color = Color(0xFF043C5B))
                                .border(1.dp, Color.White)
                        ) {
                            Text(
                                "Kendaraan",
                                modifier = Modifier
                                    .wrapContentSize()
                                    .align(Alignment.Center),
                                color = Color.White
                            )
                        }
                    }

                    Row(modifier = Modifier.padding(top = 0.dp)) {
                        Box(
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(bottomStart = 18.dp))
                                .height(40.dp)
                                .width(100.dp)
                                .weight(1f)
                                .background(color = Color(0xFF043C5B))
                                .border(1.dp, Color.White)
                        ) {
                            Text(
                                "Pakaian",
                                modifier = Modifier
                                    .wrapContentSize() // Adjust size based on content
                                    .align(Alignment.Center),
                                color = Color.White
                            )
                        }
                        Box(
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(bottomEnd = 18.dp))
                                .height(40.dp)
                                .width(100.dp)
                                .weight(1f)
                                .background(color = Color(0xFF043C5B))
                                .border(1.dp, Color.White)
                        ) {
                            Text(
                                "Peralatan",
                                modifier = Modifier
                                    .wrapContentSize() // Adjust size based on content
                                    .align(Alignment.Center),
                                color = Color.White
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Terbaru",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        Icons.Default.KeyboardArrowRight,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Card terbaru
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
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
                                        painter = painterResource(id = R.drawable.productcamera),
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
                                            imageVector = Icons.Rounded.FavoriteBorder,
                                            contentDescription = "Love",
                                            tint = Color.Gray // Warna ikon
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
                                        text = "Kamera EOS 3000D",
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
                                            text = "batam",
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
                                            text = "Hobi",
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
                                            text = "Rp125.000/hari",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 12.sp,
                                            modifier = Modifier.padding(bottom = 4.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                    
                    Spacer(modifier = modifier.width(20.dp))

                    // Tambahkan Card kedua jika diperlukan
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
                                        painter = painterResource(id = R.drawable.productfashion),
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
                                            imageVector = Icons.Rounded.FavoriteBorder,
                                            contentDescription = "Love",
                                            tint = Color.Gray // Warna ikon
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
                                        text = "Kamera EOS 3000D",
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
                                            text = "Tanjungpinang",
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
                                            containerColor = Color.Yellow
                                        ),
                                        contentPadding = PaddingValues(0.dp) // Atur padding untuk memastikan teks berada di tengah
                                    ) {
                                        Text(
                                            text = "Pakaian",
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
                                            text = "Rp100.000/hari",
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











                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Paling Banyak DiSewa",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        Icons.Default.KeyboardArrowRight,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))

                // Card Paling laris
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
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
                                        painter = painterResource(id = R.drawable.productmobil),
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
                                            imageVector = Icons.Rounded.FavoriteBorder,
                                            contentDescription = "Love",
                                            tint = Color.Gray // Warna ikon
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
                                        text = "Rental Mobil",
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
                                            text = "Jakarta",
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
                                            text = "Kendaraan",
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
                                            text = "Rp450.000/hari",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 12.sp,
                                            modifier = Modifier.padding(bottom = 4.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }

                    // Tambahkan Card kedua jika diperlukan
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
                                        painter = painterResource(id = R.drawable.productcampset),
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
                                            imageVector = Icons.Rounded.FavoriteBorder,
                                            contentDescription = "Love",
                                            tint = Color.Gray // Warna ikon
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
                                        text = "Camp Set",
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
                                            text = "Hj Unggar City",
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
                                            containerColor = Color.Yellow
                                        ),
                                        contentPadding = PaddingValues(0.dp) // Atur padding untuk memastikan teks berada di tengah
                                    ) {
                                        Text(
                                            text = "Peralatan",
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
                                            text = "Rp250.000/hari",
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


                Spacer(modifier = modifier.height(30.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun homeprev() {
    HomeScreen(navController = rememberNavController())
}
