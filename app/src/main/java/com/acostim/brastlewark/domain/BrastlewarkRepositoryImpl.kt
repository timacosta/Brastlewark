package com.acostim.brastlewark.domain

import com.acostim.brastlewark.core.Resource
import com.acostim.brastlewark.data.local.GnomeEntity
import com.acostim.brastlewark.data.local.LocalDataSource
import com.acostim.brastlewark.data.model.BrastlewarkCity
import com.acostim.brastlewark.data.model.Gnome
import com.acostim.brastlewark.data.model.asGnomeEntity
import com.acostim.brastlewark.data.remote.BrastlewarkService
import com.acostim.brastlewark.data.remote.NetworkDataSource
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject


@ExperimentalCoroutinesApi
@ActivityRetainedScoped
class BrastlewarkRepositoryImpl
@Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val localDataSource: LocalDataSource,
    ): BrastlewarkRepository {

    override suspend fun getAllGnomes(): Flow<Resource<List<Gnome>>> =
        callbackFlow {

            offer(getCachedGnomes())

            networkDataSource.getGnomes().collect {
                when(it) {
                    is Resource.Success -> {
                        for(gnome in it.data) {
                            saveGnome(gnome.asGnomeEntity())
                        }
                        offer(getCachedGnomes())
                    }
                    is Resource.Failure -> {
                        offer(getCachedGnomes())
                    }
                }
            }
            awaitClose { cancel() }
        }

    override suspend fun getCachedGnomes(): Resource<List<Gnome>> {
        return localDataSource.getCachedGnomes()
    }

    override suspend fun saveGnome(cocktail: GnomeEntity) {
        localDataSource.saveGnome(cocktail)
    }

}