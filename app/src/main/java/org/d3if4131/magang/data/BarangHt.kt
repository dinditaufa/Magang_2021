package org.d3if4131.magang.data

import org.d3if4131.magang.db.BarangEntity

object BarangHt {
    fun hitung(data: BarangEntity): BarangHs {
        val hasil = data.bawang+data.kobis
        return BarangHs(hasil)
    }
}