package com.acostim.brastlewark.data.remote

import com.acostim.brastlewark.core.Resource
import com.acostim.brastlewark.data.model.BrastlewarkCity
import com.acostim.brastlewark.data.model.Gnome
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

@ExperimentalCoroutinesApi
class NetworkDataSource @Inject constructor(
    private val brastlewarkService: BrastlewarkService
) {

    suspend fun getGnomes(): Flow<Resource<List<Gnome>>> =
        callbackFlow {
            offer(
                Resource.Success(
                    brastlewarkService.getAllGnomes().brastlewark ?: listOf()
                )
            )
            awaitClose{ close() }
        }

}