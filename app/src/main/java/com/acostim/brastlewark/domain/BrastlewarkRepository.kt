package com.acostim.brastlewark.domain

import com.acostim.brastlewark.core.Resource
import com.acostim.brastlewark.data.local.GnomeEntity
import com.acostim.brastlewark.data.model.Gnome
import kotlinx.coroutines.flow.Flow


interface BrastlewarkRepository {
    suspend fun getAllGnomes(): Flow<Resource<List<Gnome>>>
    suspend fun getCachedGnomes(): Resource<List<Gnome>>
    suspend fun saveGnome(gnome: GnomeEntity)
}