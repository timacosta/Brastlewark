package com.acostim.brastlewark.repository

import com.acostim.brastlewark.network.Brastlewark

interface BrastlewarkRepository {
    suspend fun getAllGnomes(): Brastlewark
}