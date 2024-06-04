@file:OptIn(ExperimentalMaterial3Api::class)

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.zerentapp.data.Data.sampleStatus
import com.example.zerentapp.model.Barang
import com.example.zerentapp.model.Status
import com.example.zerentapp.ui.theme.color1

val garis = Color(android.graphics.Color.parseColor("#33373737"))
val biggaris = Color(android.graphics.Color.parseColor("#E9F5FE"))

@Composable
fun StatusScreen(status: MutableState<Status>) {
    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    var items = remember { mutableListOf(
        "Kamera EOS 50D",
        "Kamera Mainan",
    ) }
    Text(
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF043C5B),
        modifier = Modifier
            .padding(start = 50.dp)
            .padding(top = 15.dp)



        ,
        text = "Pesanan Saya"
       )
    Column(modifier = Modifier
        .padding(top = 15.dp)
        .width(800.dp)
        .offset(y = 65.dp,)
        .height(60.dp)
        .size(390.dp)
        .clip(RoundedCornerShape(5.dp))
        .background(color = biggaris)
    ) {

    }


    SearchBar(
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = if (active) 1.dp else 150.dp,)
            .clickable {

                active = !active
            }

        ,
        query = text,
        onQueryChange = {
            text = it
        },
        onSearch = {
            items.add(text)
            active = false
        },
        active = active,
        onActiveChange = {
            active = it
        },
        placeholder = {
            Text(text = "search")
        },
        leadingIcon = {
           Icon(imageVector =   Icons.Default.Search, contentDescription = "search",)
        },
        trailingIcon = {
          if(active) {
              Icon(
                  modifier = Modifier
                      .clickable{
                          if(text.isNotEmpty()){
                              text = ""
                          } else {
                              active = false
                          }

                      }
                  ,
                  imageVector =   Icons.Default.Close,
                  contentDescription = "close")
          }
        }) {
items.forEach{
    Row(modifier = Modifier

        ,) {
        Spacer(modifier = Modifier.height(20.dp))
        Icon(imageVector =   Icons.Default.History, contentDescription = "history",)
        Text(text = it)
    }
}
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        StatusSelection(statusList = sampleStatus, currentStatus = status)
        Spacer(modifier = Modifier.height(16.dp))
        StatusSection(status = status.value)

    }
}


@Composable
fun StatusSelection(statusList: List<Status>, currentStatus: MutableState<Status>) {



    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier

    ) {
        item {

                     Row {
                         LazyRow(
                             contentPadding = PaddingValues(16.dp),
                             horizontalArrangement = Arrangement.spacedBy(8.dp),
                             modifier = Modifier
                                 .padding(top = 60.dp, )

                         ) {

                             items(statusList) { status ->

                                 Row {
                                     Text(
                                         text = "${status.name}",
                                         modifier = Modifier
                                             .padding(horizontal = 10.dp,)
                                             .clip(RoundedCornerShape(10.dp))
                                             .clickable { currentStatus.value = status }
                                             .background(
                                                 if (currentStatus.value == status) {
                                                     Color(0xFF043C5B)
                                                 } else {
                                                     Color(0xFFE9F5FE)
                                                 }
                                             )
//                                             .border(
//                                                 width = 1.5.dp,
//                                                 shape = RoundedCornerShape(10.dp),
//                                                 color = if (currentStatus.value == status) Color(
//                                                     0xFF043C5B
//                                                 ) else Color(
//                                                     0xFFE9F5FE
//                                                 )
//                                             )

                                             .padding(10.dp)

                                         ,
                                         fontSize = 14.sp,
                                         color = if (currentStatus.value == status) Color.White else Color.Black,
                                         fontWeight = if (currentStatus.value == status) FontWeight.Bold else FontWeight.Medium ,

                                     )
                                 }
                             }
                         }
                     }
            }

        }

    }
@Composable
fun StatusSection(status: Status) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 60.dp)
            .padding(vertical = 8.dp)

    ) {
        Text(
            modifier = Modifier
                .padding(bottom = 17.dp)
            ,
            text = status.name,
            style = MaterialTheme.typography.headlineSmall
        )
        LazyColumn {
            items(status.items  ) { barang ->
                BarangCard(barang = barang)

            }

        }
    }
}

@Composable
fun BarangCard(barang: Barang,

) {

    val isSelected = remember { mutableStateOf(false) }
    Card(
        modifier = Modifier

            .fillMaxWidth()
            .padding(vertical = 10.dp,)
            .padding(start = 2.dp, end = 2.dp, top = 10.dp)
            .shadow(
                9.dp, RoundedCornerShape(10.dp),
                spotColor = Color.Black,
                ambientColor = Color.Black
            )
            .clip(RoundedCornerShape(10.dp))
        ,
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFEBEBEB),

        )


    ) {
        

        
        Column(
            modifier = Modifier
                .padding(10.dp)
                .background(Color(0xFFEBEBEB))) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp, top = 8.dp),
                contentAlignment = Alignment.TopEnd
            ) {
                Text(
                    text = "Deposit",
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.Black,
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.Gray)
                        .padding(4.dp)
                )
            }
            Row(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .padding(bottom = 10.dp)
                    .offset(y = -5.dp,)
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                Image(
                    painter = painterResource(id = barang.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .size(height = 94.dp, width = 100.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column(
                    modifier = Modifier
                ) {
                    Text(
                        text = barang.name,
                        style = MaterialTheme.typography.titleSmall,

                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Durasi : ${barang.waktu} Hari",
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
            Row(
                modifier = Modifier.padding(top = 10.dp)
            ){
                Text(
                    modifier = Modifier
                        .padding(start = 15.dp)
                    ,
                    text = "Rp${barang.harga}/hari",)
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    modifier = Modifier
                        .padding(end = 5.dp)
                    ,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    text = "Total:")
                Text(
                    modifier = Modifier
                        .padding(end = 15.dp, bottom = 10.dp)
                    ,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    text = "Rp 150.000")
            }
            Divider(color = garis, thickness = 1.dp, modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp))
            Row(
                modifier = Modifier
                    .padding(top = 15.dp)
                    .padding(start = 5.dp)
            ){
                Image(
                    painter = painterResource(id = barang.imaget),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .size(height = 35.dp, width = 35.dp)
                )
                Text(modifier = Modifier
                    .padding(start = 10.dp, top = 7.dp)
                    ,
                    text = barang.title_toko,)
                Spacer(modifier = Modifier.weight(1f))
                    Row(

                    modifier = Modifier
                        .padding(end = 8.dp)
                        .offset(y = -5.dp)


                ) {
                        Row {
                             Text(
                        text = "${barang.button_action}",
                        modifier = Modifier

                            .padding(horizontal = 10.dp,)
                            .clip(RoundedCornerShape(10.dp))
                            .clickable { isSelected.value = !isSelected.value }
                            .background(
                                if (isSelected.value) {
                                    Color(0xFF043C5B)
                                } else {
                                    Color(0xFFFFFFFF)
                                }
                            )
                            .border(
                                width = 1.5.dp,
                                shape = RoundedCornerShape(10.dp),
                                color = if (isSelected.value) Color(
                                    0xFF043C5B
                                ) else Color(
                                    0xFF043C5B
                                )
                            )

                            .padding(10.dp)

                        ,
                        fontSize = 14.sp,
                        color = if (isSelected.value) Color.White else Color(0xFF043C5B),
                        fontWeight = if (isSelected.value) FontWeight.Bold else FontWeight.Medium ,

                        )
                        }
               
                }
            }
        }
    }
}

@Composable
fun Order(navController: NavHostController) {
    val currentStatus = remember { mutableStateOf(sampleStatus[0]) }

    Surface(color = MaterialTheme.colorScheme.background) {
        StatusScreen(status = currentStatus)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Order(navController = rememberNavController())
}
