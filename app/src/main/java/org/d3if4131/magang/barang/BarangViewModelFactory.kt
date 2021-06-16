package org.d3if4131.magang.barang

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if4131.magang.db.BarangDao
import java.lang.IllegalArgumentException

class BarangViewModelFactory (
    private val db: BarangDao
) : ViewModelProvider.Factory {
    @Suppress("unhecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BarangViewModel::class.java)) {
            return BarangViewModel(db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}