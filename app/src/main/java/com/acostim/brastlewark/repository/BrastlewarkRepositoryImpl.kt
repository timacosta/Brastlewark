package com.acostim.brastlewark.repository

import com.acostim.brastlewark.network.Brastlewark
import com.acostim.brastlewark.network.BrastlewarkService

class BrastlewarkRepositoryImpl
constructor(private val brastlewarkService: BrastlewarkService): BrastlewarkRepository {

    override suspend fun getAllGnomes(): Brastlewark {
        return brastlewarkService.getAllGnomes()
    }
}