package com.acostim.brastlewark.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson

class AppConverter {
    @TypeConverter
    fun fromListToJson(value: List<String>?) = Gson().toJson(value)

    @TypeConverter
    fun fromJsonToList(value: String) = Gson().fromJson(value, Array<String>::class.java).toList()
}