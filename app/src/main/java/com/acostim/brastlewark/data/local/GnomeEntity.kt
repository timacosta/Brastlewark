package com.acostim.brastlewark.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gnomeTable")
data class GnomeEntity(
    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "thumbnail")
    val thumbnail: String,

    @ColumnInfo(name = "age")
    val age: Int,

    @ColumnInfo(name = "weight")
    val weight: Double,

    @ColumnInfo(name = "height")
    val height: Double,

    @ColumnInfo(name = "hair_color")
    val hair_color: String,

    @ColumnInfo(name = "professions")
    val professions: List<String>,

    @ColumnInfo(name = "friends")
    val friends: List<String>
)