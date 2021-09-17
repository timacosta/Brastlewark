package com.acostim.brastlewark.data.local

import androidx.room.Database
import com.acostim.brastlewark.data.model.GnomeEntity

@Database(entities = [GnomeEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase {
    abstract fun gnomeDao(): GnomeDao
}