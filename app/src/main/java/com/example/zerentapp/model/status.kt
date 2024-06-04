package com.example.zerentapp.model

data class Barang(
    val name: String,
    val description: String,
    val harga: String,
    val waktu : Int,
    val image:Int,
    val imaget:Int,
    val title_toko: String,
    val button_action: String,
)

data class Status(
    val name: String,
    val items: List<Barang>,


)






