package org.d3if4131.magang.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "barang")
class BarangEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var bawang: Float,
    var kobis: Float
)