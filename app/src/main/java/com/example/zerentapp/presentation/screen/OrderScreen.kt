import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import com.example.zerentapp.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.zerentapp.data.Data.sampleStatus
import com.example.zerentapp.model.Barang
import com.example.zerentapp.model.Status


@Composable
fun StatusScreen(status: MutableState<Status>) {
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
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(statusList) { status ->
            Button(onClick = { currentStatus.value = status }, modifier = Modifier.padding(end = 8.dp)) {
                Text(text = status.name)
            }
        }
    }
}

@Composable
fun StatusSection(status: Status) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = status.name,
            style = MaterialTheme.typography.headlineSmall
        )
        LazyColumn {
            items(status.items) { barang ->
                BarangCard(barang = barang)
            }
        }
    }
}

@Composable
fun BarangCard(barang: Barang) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp, top = 8.dp),
                contentAlignment = Alignment.TopEnd
            ) {
                Text(
                    text = "Deposit",
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.White,
                    modifier = Modifier.background(Color.Gray).padding(4.dp)
                )
            }
            Row(
                modifier = Modifier
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                Image(
                    painter = painterResource(id = barang.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(height = 80.dp, width = 100.dp)
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
                modifier = Modifier.padding(top = 8.dp)
            ){
                Text(
                    text = "Rp${barang.harga}/hari",)
                Spacer(modifier = Modifier.weight(1f))
                Text(text = "Rp 150.000")
            }
            Divider(color = Color.Black, thickness = 1.dp, modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp))
            Row(
                modifier = Modifier
            ){
                Text(text = "Toko serba ada",)
                Spacer(modifier = Modifier.weight(1f))
                Button(onClick = {}, modifier = Modifier.padding(end = 8.dp)) {
                    Text(text = "Bayar sekarang")
                }
            }
        }
    }
}

@Composable
fun Order() {
    val currentStatus = remember { mutableStateOf(sampleStatus[0]) }

    Surface(color = MaterialTheme.colorScheme.background) {
        StatusScreen(status = currentStatus)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Order()
}
