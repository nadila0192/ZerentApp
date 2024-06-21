package com.example.zerentapp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.StarOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.zerentapp.R
import com.example.zerentapp.model.dUlasan
import com.example.zerentapp.ui.theme.ZerentAppTheme


@Composable
fun InRatingBar(
    modifier: Modifier = Modifier,
    rating: Double = 0.0,
    stars: Int = 5,
    onRatingChanged: (Double) -> Unit ,
    starsColor: Color = Color.Black
){
    var halfStar = (rating % 1) != 0.0

    Row {
        for (index in 1..stars) {
            Icon(
                imageVector =
                if (index <= rating) {
                    Icons.Rounded.Star
                } else {
                    if (halfStar) {
                        halfStar = false
                        Icons.Rounded.StarHalf
                    } else {
                        Icons.Rounded.StarOutline
                    }
                },
                contentDescription = null,
                tint = starsColor,
                modifier = modifier
                    .clickable{ onRatingChanged(index.toDouble()) }
            )
        }
    }
}

@Composable
fun InUlasanScreen(
    navController: NavHostController = rememberNavController(),
    ulasan: dUlasan,
    modifier: Modifier = Modifier,
    pesan: String = "",
    OnPesanChange: (String) -> Unit,
    onItemClicked: (Int) -> Unit
){

    var rating by remember { mutableStateOf(0.0) }

    Column(
        modifier = Modifier
            .size(width = 300.dp, height = 500.dp)
            .border(width = 1.dp, Color.Black, shape = RoundedCornerShape(7.dp))
        ,
    ) {
        Column (modifier = Modifier
            .padding(horizontal = 5.dp),){
            Text( modifier = Modifier
                .padding(horizontal = 80.dp, vertical = 10.dp),
                text = "Beri Rating",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            RatingBar(
                modifier = Modifier
                    .padding(bottom = 10.dp),
                rating = rating,
                stars = 5,
                onRatingChanged = { newRating ->
                    rating = newRating
                },
                starsColor = Color.Yellow
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = 5.dp)

            ) {

                OutlinedTextField(
                    value = pesan,
                    onValueChange = OnPesanChange,
                    label = {Text(text = "Beritahu Kami Alasannya!!")},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    visualTransformation = VisualTransformation.None,
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.size(width = 300.dp, height = 350.dp)

                )
            }
            Button(
                onClick = { navController.navigate("check") },
                modifier = Modifier
                    .padding(horizontal = 80.dp, vertical = 10.dp)
                    .size(width = 120.dp, height = 35.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF043C5B)),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "Konfirmasi",
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InUlasanScreenPreview(){
    ZerentAppTheme {
InUlasanScreen(OnPesanChange = {}, ulasan = dUlasan(id = 1, nama = "Hamdan", pesan = "Worth it bnget sewa nyaa, kualitas oke... juga masuk dikantong harganya", email = "mj@gmail.com" ,foto = R.drawable.img), onItemClicked = {})
    }
}