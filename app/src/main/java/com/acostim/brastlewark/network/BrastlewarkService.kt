package com.acostim.brastlewark.network

import retrofit2.http.GET


interface BrastlewarkService {

    companion object {
        private const val BRASTLEWARK_PATH = "rrafols/mobile_test/master/data.json"
    }

    @GET(BRASTLEWARK_PATH)
    suspend fun getAllGnomes(): Brastlewark

}