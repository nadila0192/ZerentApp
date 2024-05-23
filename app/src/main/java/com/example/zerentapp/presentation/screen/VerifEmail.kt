package com.example.zerentapp.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusOrder
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.zerentapp.R
import com.example.zerentapp.ui.theme.BackgroungLogin
import com.example.zerentapp.ui.theme.ZerentAppTheme
import com.example.zerentapp.ui.theme.color1
import com.example.zerentapp.ui.theme.color2
import com.example.zerentapp.ui.theme.poppinsFontFamily

@Composable
fun VerifEmail(
    navController: NavController
){
    val otpVal: String? = null
    BackgroungLogin (
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_login),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp),
                    alignment = Alignment.Center
                )
                Text(
                    modifier = Modifier
                        .padding(bottom = 50.dp),
                    text = "Verifikasi Email",
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center,
                    fontFamily = poppinsFontFamily, fontWeight = FontWeight.Bold,
                    color = Color.White,
                )
                Column (
                    modifier = Modifier
                        .shadow(
                            elevation = 5.dp,
                            shape = RoundedCornerShape(30.dp)
                        )
                        .size(width = 320.dp, height = 280.dp)
                        .background(Color.White),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        modifier = Modifier
                            .padding(top = 30.dp),
                        text = "Kode Verifikasi Telah Dikirim ke Email. \n Cek Email Anda!",
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center,
                        fontFamily = poppinsFontFamily, fontWeight = FontWeight.W500
                    )
                    var otpValue by remember {
                        mutableStateOf("")
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    BasicTextField(
                        value = otpValue,
                        onValueChange = {
                            if (it.length <= 6){
                                otpValue = it
                            }
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.NumberPassword
                        ),
                        decorationBox = {
                            Row (
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier
                            ){
                                repeat(6){index ->
                                    val char = when{
                                        index >= otpValue.length -> ""
                                        else -> otpValue[index].toString()
                                    }
                                    val isFocused = otpValue.length == index
                                    Spacer(modifier = Modifier.width(5.dp))
                                    Text(
                                        modifier = Modifier
                                            .size(45.dp)
                                            .border(
                                                if (isFocused)1.dp
                                                else 1.dp,
                                                if (isFocused) Color.LightGray
                                                else Color.LightGray,
                                                RoundedCornerShape(8.dp)
                                            )
                                            .padding(2.dp)
                                            .background(color2),
                                        text = char,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = Color.DarkGray,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }
                    )
                    Row (
                        modifier = Modifier
                            .padding(top = 25.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Belum menerima kode?",
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Center,
                            fontFamily = poppinsFontFamily, fontWeight = FontWeight.Normal,
                            color = Color.Black,
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "Kirim Ulang",
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Start,
                            fontFamily = poppinsFontFamily, fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            textDecoration = TextDecoration.Underline,
                            modifier = Modifier
                                .clickable { navController.navigate("register") }
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Button(
                        onClick = { navController.navigate("home")},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = color1
                        ),
                        modifier = Modifier
                            .size(width = 280.dp, height = 40.dp),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            text = "Konfirmasi",
                            style = MaterialTheme.typography.bodyLarge,
                            textAlign = TextAlign.Center,
                            fontFamily = poppinsFontFamily, fontWeight = FontWeight.Bold)
                    }
                }

            }
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 170.dp)
                    .background(color1)
                    .height(31.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ){
                Text(
                    text = "Kualitas Tanpa Kepemilikan, Nikmati dengan Sewa",
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Center,
                    fontFamily = poppinsFontFamily, fontWeight = FontWeight.Normal,
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VerifEMailScreenPreview(){
    ZerentAppTheme {
        VerifEmail(navController = rememberNavController())

    }
}