package com.tauhidizzan.pencatatstok

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StokBarang (
    @PrimaryKey(autoGenerate = true)
    val barangID: Int? = null,
    val kodeBarang : String,
    val namaBarang : String,
    val jmlStok : Int,
    val hppBarang : Int,
    val hargaJual: Int,
)
