package com.acostim.brastlewark.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.acostim.brastlewark.R
import com.acostim.brastlewark.data.model.Gnome
import com.acostim.brastlewark.databinding.MainActivityBinding
import com.acostim.brastlewark.databinding.MainFragmentBinding
import com.acostim.brastlewark.presentation.BrastlewarkViewModel
import com.acostim.brastlewark.ui.main.adapter.BrastlewarkAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainFragment : Fragment(R.layout.main_fragment),
    BrastlewarkAdapter.OnGnomeClickListener {

    private lateinit var binding: MainFragmentBinding
    private lateinit var adapter: BrastlewarkAdapter
    private val viewModel by activityViewModels<BrastlewarkViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        adapter = BrastlewarkAdapter(requireContext(), this)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = MainFragmentBinding.bind(view)


    }

    override fun onGnomeClick(gnome: Gnome, position: Int) {
        TODO("Not yet implemented")
    }

}