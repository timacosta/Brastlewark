package com.acostim.brastlewark.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.acostim.brastlewark.R
import com.acostim.brastlewark.databinding.MainActivityBinding
import com.acostim.brastlewark.presentation.BrastlewarkViewModel
import com.acostim.brastlewark.ui.main.adapter.BrastlewarkAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater).also { setContentView(it.root) }

    }

}

