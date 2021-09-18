package com.acostim.brastlewark.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.acostim.brastlewark.R
import com.acostim.brastlewark.data.model.Gnome
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

        binding = MainFragmentBinding.bind(view)

        //TODO: Create layout and bindings

        viewModel.fetchGnomeList.observe(viewLifecycleOwner, Observer { result ->

        })

    }

    override fun onGnomeClick(gnome: Gnome, position: Int) {
        TODO("Not yet implemented")
    }

}