package com.acostim.brastlewark.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface GnomeDao {
    @Query("SELECT * FROM gnomeTable")
    suspend fun getAllGnomes(): List<GnomeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGnome(gnome: GnomeEntity)

}