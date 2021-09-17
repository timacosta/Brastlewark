package com.acostim.brastlewark.data.local

import androidx.room.Dao
import com.acostim.brastlewark.data.model.Gnome
import com.acostim.brastlewark.data.model.GnomeEntity

@Dao
interface GnomeDao {
    //TODO: Add Query
    suspend fun getAllGnomes(): List<GnomeEntity>
}