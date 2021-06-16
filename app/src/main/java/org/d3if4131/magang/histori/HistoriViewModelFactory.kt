package org.d3if4131.magang.histori

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if4131.magang.db.BarangDao

class HistoriViewModelFactory (
    private val db: BarangDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HistoriViewModel::class.java)) {
            return HistoriViewModel(db) as T

        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}