package org.d3if4131.magang.histori

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if4131.magang.db.BarangDao

class HistoriViewModel(private val db: BarangDao) : ViewModel() {
    val data = db.getLastBarang()
    fun hapusData() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            db.clearData()
        }
    }
}