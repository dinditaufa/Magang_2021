package org.d3if4131.magang.barang

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if4131.magang.data.BarangHs
import org.d3if4131.magang.data.BarangHt
import org.d3if4131.magang.db.BarangDao
import org.d3if4131.magang.db.BarangEntity

class BarangViewModel(private val db: BarangDao) :  ViewModel() {

    private val hasilBarang = MutableLiveData<BarangHs?>()

    fun hitungBarang(bawang: String, kobis: String) {
        val dataBarang = BarangEntity(
            bawang = bawang.toFloat(),
            kobis = kobis.toFloat()
        )
        hasilBarang.value = BarangHt.hitung(dataBarang)
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataBarang)
            }
        }
    }
    fun getHasilBarang() : LiveData<BarangHs?> = hasilBarang
}