package com.example.zerentapp.presentation.component

import android.app.AlertDialog
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogPosting(onDismiss: () -> Unit, modifier: Modifier = Modifier ) {
    var selectedCity by remember { mutableStateOf("") }
    var selectedDistrict by remember { mutableStateOf("") }
    var no by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {},
        modifier = Modifier.height(550.dp),
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Tambahkan Lokasi",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        },
        text = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                item {
                    Text(text = "Masukkan informasi lokasi dengan akurat", fontSize = 14.sp)

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(text = "Kota", fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(5.dp))

                    ExposedDropdownitem(items = arrayOf("bandung","semarang","jakarta") )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(text = "Kecamatan", fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(5.dp))

                    ExposedDropdownitem(items = arrayOf("cibaduyut","ciasem","cimanis"))

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(text = "No", fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = no,
                        onValueChange = { no = it },
                        modifier = modifier
                            .border(1.dp, Color.Black, RoundedCornerShape(4.dp))
                            .background(Color.White, RoundedCornerShape(4.dp))
                            .fillMaxWidth()
                            .height(56.dp)
                            .padding(horizontal = 0.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        )
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Button(
                            onClick = { /* Handle apply action */ },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xff043C5B)
                            ),
                            modifier = Modifier
                                .width(120.dp)
                                .height(48.dp)
                        ) {
                            Text(text = "Terapkan", color = Color.White)
                        }
                    }
                }
            }
        }
    )
}













@Preview(showBackground = true)
@Composable
private fun AlertDialogPrev() {
    AlertDialogPosting(onDismiss = { /*TODO*/ }, modifier = Modifier)}
