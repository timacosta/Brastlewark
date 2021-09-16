package com.acostim.brastlewark.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.acostim.brastlewark.R
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}