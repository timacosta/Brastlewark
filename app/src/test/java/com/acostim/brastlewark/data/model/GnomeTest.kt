package com.acostim.brastlewark.data.model

import com.google.common.truth.Truth.assertThat
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

class GnomeTest {

    private lateinit var gnome: Gnome

    @Before
    fun setup() {
        gnome = Gnome(
            id = 0,
            name = "Tobus Quickwhistle",
            thumbnail = "http://www.publicdomainpictures.net/pictures/10000/nahled/thinking-monkey-11282237747K8xB.jpg",
            age = 28,
            weight = 40.0,
            height = 170.0,
            hair_color = "Blonde",
            professions = listOf("Metalworker", "Woodcarver"),
            friends = listOf("Cogwitz Chillwidget", "Tinadette Chillbuster")
        )
    }

    @Test
    fun testGnomeCreation() {
        assertThat(gnome.id).isEqualTo(0)
        assertThat(gnome.name).isEqualTo("Tobus Quickwhistle")
        assertThat(gnome.age).isEqualTo(28)
        assertThat(gnome.weight).isEqualTo(40.0)
        assertThat(gnome.height).isEqualTo(170.0)
        assertThat(gnome.hair_color).isEqualTo("Blonde")
        assertThat(gnome.professions.size).isEqualTo(2)
        assertThat(gnome.friends.size).isEqualTo(2)
    }



}