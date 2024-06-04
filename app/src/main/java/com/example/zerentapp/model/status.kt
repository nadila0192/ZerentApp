package com.example.zerentapp.model

data class Barang(
    val name: String,
    val description: String,
    val harga: String,
    val waktu : Int,
    val image:Int
)

data class Status(
    val name: String,
    val items: List<Barang>
)

