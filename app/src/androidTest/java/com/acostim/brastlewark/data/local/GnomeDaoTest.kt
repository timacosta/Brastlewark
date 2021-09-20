package com.acostim.brastlewark.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named

@HiltAndroidTest
class GnomeDaoTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    @Named("test_db")
    lateinit var database: AppDatabase
    private lateinit var dao: GnomeDao

    @Before
    fun setup() {
        hiltRule.inject()
        dao = database.gnomeDao()
    }

    @After
    fun tearDown() {
        database.close()
    }


    @Test
    fun testInsertGnome() = runBlockingTest {
        val gnomeEntity = GnomeEntity(
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
        dao.insertGnome(gnomeEntity)
        val gnomes = dao.getAllGnomes()

        assertThat(gnomes).isNotEmpty()
        assertThat(gnomes[0].name).isEqualTo("Tobus Quickwhistle")

    }


}