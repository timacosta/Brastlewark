package com.acostim.brastlewark.network

import com.squareup.moshi.Json

data class GnomeNetworkModel(

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

data class Brastlewark(

    @Json(name = "Brastlewark")
    val brastlewark: List<GnomeNetworkModel>
    
)
