package com.example.zerentapp.data

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.zerentapp.R
import com.example.zerentapp.model.dBarang
import com.example.zerentapp.model.dCheck
import com.example.zerentapp.model.dPembayaran
import com.example.zerentapp.model.dUlasan

object Data {
    val dataBarang = listOf(
        dBarang(
            id = 1,
            nama = "Kamera EOS 3000D",
            harga = "125000",
            detail = "Menyewakan kamera Canon untuk kebutuhan tugas, hunting foto serta keperluan lainnya.",
            lokasi = "Batam",
            foto = R.drawable.canon3000d
        ),
        dBarang(
            id = 2,
            nama = "Fighting Nora Costume",
            harga = "100000",
            detail = "Rental cosplay costume mu dengan mudah dan cepat disini.",
            lokasi = "Batam",
            foto = R.drawable.nora
        ),
    )

    val dataUlasan = listOf(
        dUlasan(
            id = 1,
            nama = "Hamdan",
            email = "mj@gmail.com",
            pesan = "Worth it bnget sewa nyaa, kualitas oke... juga masuk dikantong harganya",
            foto = R.drawable.img
        ),
        dUlasan(
            id = 2,
            nama = "Hendra",
            email = "mj2@gmail.com",
            pesan = "Siipp gua mahh, gk ribet . praktis, bagus lagi",
            foto = R.drawable.img_1
        ),
    )

    val dataCheck = listOf(
        dCheck(
            id = 1,
            namaToko = "Ada Kamera Store",
            nama = "Kamera EOS 3000D",
            harga = "125000",
            jumlah = "1",
            alamat = "Temoyong, Bulang",
            tanggal_pinjam = "04/12/2024",
            tanggal_kembali = "05/12/2024",
            total = "1",
            foto = R.drawable.img_2
        )
    )

    val dataPembayaran = listOf(
        dPembayaran(
            id = 1,
            sub_total = "125000",
            deposit = "50000",
            ongkir = "0",
            layanan = "50000",
            Total = "225000"
        )
    )
}
