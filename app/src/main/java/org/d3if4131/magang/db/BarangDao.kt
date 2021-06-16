package org.d3if4131.magang.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BarangDao {
    @Insert
    fun insert(barang: BarangEntity)
    @Query("SELECT * FROM barang ORDER BY id DESC")
    fun getLastBarang(): LiveData<List<BarangEntity>>
    @Query("DELETE FROM barang")
    fun clearData()
}