package com.acostim.brastlewark.model

import java.io.Serializable


data class Gnome(
    val id: Int,
    val name: String,
    val thumbnail: String,
    val age: Int,
    val weight: Double,
    val hair_color: String,
    val professions: List<String>,
    val friends: List<String>

): Serializable

data class Brastlewark(
    val brastlewark: List<Gnome>
): Serializable
