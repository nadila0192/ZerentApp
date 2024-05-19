package com.example.zerentapp.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.zerentapp.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RequestScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Request",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF6200EE) // Ubah warna sesuai keinginan Anda
                )
            )
        }
    ) {
        // Konten utama dari layar dengan padding top untuk menghindari AppBar
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding() + 16.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
        ) {
            // Data dummy untuk ditampilkan dalam LazyColumn
            val users = listOf(
                User("Nama Pengguna 1", "1 jam yang lalu", R.drawable.lucas),
                User("Nama Pengguna 2", "2 jam yang lalu", R.drawable.lucas),
                User("Nama Pengguna 3", "3 jam yang lalu", R.drawable.lucas)
                // Tambahkan data dummy sesuai kebutuhan
            )

            items(users) { user ->
                UserCard(user = user)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun UserCard(user: User) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = user.profileImage), // Ganti dengan id gambar profil Anda
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = user.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Terakhir online: ${user.lastOnline}",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

data class User(
    val name: String,
    val lastOnline: String,
    val profileImage: Int
)

@Preview(showBackground = true)
@Composable
fun RequestScreenPreview() {
    RequestScreen()
}
