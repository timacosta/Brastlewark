package com.acostim.brastlewark.data.model

import android.os.Parcelable
import com.acostim.brastlewark.data.local.GnomeEntity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Gnome(

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("thumbnail")
    val thumbnail: String,

    @SerializedName("age")
    val age: Int,

    @SerializedName("weight")
    val weight: Double,

    @SerializedName("height")
    val height: Double,

    @SerializedName("hair_color")
    val hair_color: String,

    @SerializedName("professions")
    val professions: List<String>,

    @SerializedName("friends")
    val friends: List<String>

): Parcelable

data class BrastlewarkCity(
    @SerializedName("Brastlewark")
    val brastlewark: List<Gnome> = listOf()
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
