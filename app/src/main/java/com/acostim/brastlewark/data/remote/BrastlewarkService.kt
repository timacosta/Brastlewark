package com.acostim.brastlewark.data.remote

import com.acostim.brastlewark.data.model.BrastlewarkCity
import retrofit2.http.GET


interface BrastlewarkService {

    companion object {
        private const val BRASTLEWARK_PATH = "rrafols/mobile_test/master/data.json"
    }

    @GET(BRASTLEWARK_PATH)
    suspend fun getAllGnomes(): BrastlewarkCity?




}