package com.tauhidizzan.pencatatstok

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StokBarangDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addStokBarang(stokBarang: StokBarang)
    @Query("SELECT * FROM StokBarang")
    fun getStokBarang(): LiveData<List<StokBarang>>
    @Update
    fun updateStokBarang(stokBarang: StokBarang)
}