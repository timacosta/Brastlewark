package com.acostim.brastlewark.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

data class Gnome(

    @Json(name = "id")
    val id: Int,

    @Json(name = "name")
    val name: String,

    @Json(name = "thumbnail")
    val thumbnail: String,

    @Json(name = "age")
    val age: Int,

    @Json(name = "weight")
    val weight: Double,

    @Json(name = "height")
    val height: Double,

    @Json(name = "hair_color")
    val hair_color: String,

    @Json(name = "professions")
    val professions: List<String>,

    @Json(name = "friends")
    val friends: List<String>

)

data class BrastlewarkCity(
    @Json(name = "Brastlewark")
    val brastlewark: List<Gnome>
)

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

fun List<GnomeEntity>.asGnomeList(): List<Gnome> = this.map { gnome ->
    Gnome(
        gnome.id,
        gnome.name,
        gnome.thumbnail,
        gnome.age,
        gnome.weight,
        gnome.height,
        gnome.hair_color,
        gnome.professions,
        gnome.friends
    )
}

fun Gnome.asGnomeEntity(): GnomeEntity =
    GnomeEntity(
        this.id,
        this.name,
        this.thumbnail,
        this.age,
        this.weight,
        this.height,
        this.hair_color,
        this.professions,
        this.friends
    )
