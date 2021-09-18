package com.acostim.brastlewark.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.acostim.brastlewark.R
import com.acostim.brastlewark.core.Resource
import com.acostim.brastlewark.data.model.Gnome
import com.acostim.brastlewark.databinding.MainFragmentBinding
import com.acostim.brastlewark.presentation.BrastlewarkViewModel
import com.acostim.brastlewark.ui.main.adapter.BrastlewarkAdapter
import com.acostim.brastlewark.utils.extensions.ui.*
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

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        binding.searchView.onQueryTextChanged {
            viewModel.setGnome(it)
        }

        viewModel.fetchGnomeList.observe(viewLifecycleOwner, Observer { result ->
            binding.progressBar.showIf { result is Resource.Loading }

            when(result) {
                is Resource.Loading -> {
                    binding.emptyContainer.root.hide()
                }
                is Resource.Success -> {
                    if(result.data.isEmpty()) {
                        binding.recyclerView.hide()
                        binding.emptyContainer.root.show()
                        return@Observer
                    }
                    binding.recyclerView.show()
                    adapter.setGnomeList(result.data)
                    binding.emptyContainer.root.hide()
                }
                is Resource.Failure -> {
                    showToast("Error during network call ${result.exception}")
                }
            }

        })

    }

    override fun onGnomeClick(gnome: Gnome, position: Int) {
        findNavController().navigate(
            MainFragmentDirections.actionMainFragmentToGnomeDetailsFragment(
                gnome
            )
        )
    }

}