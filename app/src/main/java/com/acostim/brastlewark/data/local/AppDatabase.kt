package com.acostim.brastlewark.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [GnomeEntity::class], version = 1, exportSchema = false)
@TypeConverters(AppConverter::class)
abstract class AppDatabase: RoomDatabase(){
    abstract fun gnomeDao(): GnomeDao
}