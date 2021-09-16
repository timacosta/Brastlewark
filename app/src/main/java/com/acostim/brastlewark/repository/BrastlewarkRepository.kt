package com.acostim.brastlewark.repository

import com.acostim.brastlewark.network.BrastlewarkNetwork

interface BrastlewarkRepository {
    suspend fun getAllGnomes(): BrastlewarkNetwork
}