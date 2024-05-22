package com.example.zerentapp.presentation.screen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
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
import com.example.zerentapp.ui.theme.poppinsFontFamily

@Composable
fun LoginScreen(
    navController: NavController
) {
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
                    text = "Masuk",
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
                        .size(width = 320.dp, height = 230.dp)
                        .background(Color.White),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Spacer(modifier = Modifier.height(20.dp))
                        OutlinedTextField(
                            value = "",
                            onValueChange = {},
                            label = {Text(text = "Email address")},
                            leadingIcon = {Icon(imageVector = Icons.Default.Email , contentDescription = null)},
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            visualTransformation = VisualTransformation.None,
                            shape = RoundedCornerShape(10.dp)
                        )
                        OutlinedTextField(
                            value = "",
                            onValueChange = {},
                            label = {Text(text = "Password")},
                            leadingIcon = {Icon(imageVector = Icons.Default.Lock , contentDescription = null)},
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            visualTransformation = VisualTransformation.None,
                            shape = RoundedCornerShape(10.dp)
                        )
                        Spacer(modifier = Modifier.height(18.dp))
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
                                text = "Masuk",
                                style = MaterialTheme.typography.bodyLarge,
                                textAlign = TextAlign.Center,
                                fontFamily = poppinsFontFamily, fontWeight = FontWeight.Bold)
                        }
                }
                Text(
                    modifier = Modifier
                        .padding(top = 40.dp),
                    text = "Atau Login Dengan",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    fontFamily = poppinsFontFamily, fontWeight = FontWeight.Normal,
                    color = Color.Black,
                )
                Row (
                    modifier = Modifier
                        .padding(top = 11.dp)
                ){
                    Box (
                        modifier = Modifier
                            .shadow(
                                elevation = 5.dp,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .size(40.dp)
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ){
                        Image(
                            modifier = Modifier
                                .size(40.dp),
                            painter = painterResource(id = R.drawable.logogoogle),
                            contentDescription =null,
                        )
                    }
                    Spacer(modifier = Modifier.width(19.dp))
                    Box (
                        modifier = Modifier
                            .shadow(
                                elevation = 5.dp,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .size(40.dp)
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ){
                        Image(
                            modifier = Modifier
                                .size(25.dp)  ,
                            painter = painterResource(id = R.drawable.logo_facebook),
                            contentDescription =null,
                        )
                    }
                }
                Row (
                    modifier = Modifier
                        .padding(top = 20.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Belum Punya Akun?",
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center,
                        fontFamily = poppinsFontFamily, fontWeight = FontWeight.Normal,
                        color = Color.Black,
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "Sign Up",
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Start,
                        fontFamily = poppinsFontFamily, fontWeight = FontWeight.Normal,
                        color = Color.Black,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier
                            .clickable { navController.navigate("register") }
                    )

                }
            }
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 70.dp)
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
fun LoginScreenPreview(){
    ZerentAppTheme {
        LoginScreen(navController = rememberNavController())
        
    }
}

