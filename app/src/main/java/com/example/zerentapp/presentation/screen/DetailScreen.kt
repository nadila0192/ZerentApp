package com.example.zerentapp.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.StarOutline
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.zerentapp.presentation.component.UlasanScreen
import com.example.zerentapp.data.Data
import com.example.zerentapp.model.dBarang
import com.example.zerentapp.model.dUlasan

@Composable
fun DetailScreen(
    modifier: Modifier,
    navController: NavController,
    detailId: Int?
){

}

//@Composable
//fun ratingsStroke(
//    ImageVector: ImageVector,
//    contentDescription: String?,
//    fillColor: Color,
//    strokeColor: Color,
//    widht: Dp,
//    modifier: Modifier = Modifier,
//){
//    Icon(
//        imageVector = ImageVector,
//        contentDescription = contentDescription,
//        fillColor : Color,
//        )
//}

//@Composable
//fun ratings(rating:Int){
//    Row (verticalAlignment = Alignment.CenterVertically){
//        repeat(rating){
//            ratingsStroke(
//                ImageVector = Icons.Default.Star,
//                contentDescription = null,
//                fillColor = Color.Yellow,
//                strokeColor = Color.Black,
//                widht = 2.dp
//            )
////            Icon(imageVector = Icons.Default.Star, contentDescription = null,
////                tint = Color.Yellow,
////                strokeColor = Color.Black,
////                modifier = Modifier.size(24.dp)
////            )
//        }
//    }
//}

@Composable
fun RatingBar(
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
private fun DetailCard(
    detailList: List<dBarang>,
    modifier: Modifier = Modifier,
    ulasann: List<dUlasan> = Data.dataUlasan,

){
    var rating by remember { mutableStateOf(0.0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Box(
            modifier = Modifier,
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(width = 400.dp, height = 300.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(data = detailList[0].foto)
                    .build(),
                contentDescription = "Foto Barang"
            )
        }

        //Detail
            Text(
                text = detailList[0].nama,
                modifier = Modifier,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Rp"+detailList[0].harga,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
            )

        Row (
            modifier = Modifier
        ){
            Icon(imageVector = Icons.Default.LocationOn, contentDescription = null)
            Text( modifier = Modifier, text = detailList[0].lokasi, fontSize = 15.sp)
        }
        Text(
            modifier = Modifier,
            text = detailList[0].detail,
            fontSize = 15.sp
        )

        //Ulasan
        Card(
            modifier = Modifier
                .width(400.dp)
                .height(400.dp),
            elevation = CardDefaults.cardElevation(10.dp),
            colors = CardDefaults.cardColors(Color.White)
        ) {
            Column(modifier = Modifier
                .padding(10.dp),
                ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ){
                    Text(modifier = Modifier
                        ,
                        text = "Penilaian Produk",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold)
                    Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null)
                }
                Spacer(modifier = Modifier .height(10.dp),)
                Row (
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    RatingBar(
                        modifier = Modifier.padding(5.dp),
                        rating = rating,
                        stars = 5,
                        onRatingChanged = { newRating ->
                            rating = newRating
                        },
                        starsColor = Color.Yellow
                    )
                    Text(text = "4/5",
                        color = Color.Gray)
                }

                LazyRow(
                    contentPadding = PaddingValues(10.dp),
                    modifier = modifier,
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    items(ulasann, key = { it.id }) {
                        UlasanScreen(ulasan = it) {
                        }
                    }
                }


            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailScreenPreview(){
    DetailCard(detailList = Data.dataBarang)
}