package com.acostim.brastlewark.data.local

import com.acostim.brastlewark.core.Resource
import com.acostim.brastlewark.data.model.Gnome
import com.acostim.brastlewark.data.model.asGnomeList
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
class LocalDataSource @Inject constructor(private val gnomeDao: GnomeDao){
    suspend fun getCachedGnomes(): Resource<List<Gnome>> {
        return Resource.Success(gnomeDao.getAllGnomes().asGnomeList())
    }
}