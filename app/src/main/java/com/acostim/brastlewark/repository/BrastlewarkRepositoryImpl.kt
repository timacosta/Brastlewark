package com.acostim.brastlewark.repository

import com.acostim.brastlewark.network.BrastlewarkNetwork
import com.acostim.brastlewark.network.BrastlewarkService

class BrastlewarkRepositoryImpl
constructor(private val brastlewarkService: BrastlewarkService): BrastlewarkRepository {

    override suspend fun getAllGnomes(): BrastlewarkNetwork {
        return brastlewarkService.getAllGnomes()
    }
}