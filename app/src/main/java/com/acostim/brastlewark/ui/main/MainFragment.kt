package com.acostim.brastlewark.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.acostim.brastlewark.R
import com.acostim.brastlewark.core.Resource
import com.acostim.brastlewark.data.model.Gnome
import com.acostim.brastlewark.databinding.MainFragmentBinding
import com.acostim.brastlewark.presentation.BrastlewarkViewModel
import com.acostim.brastlewark.presentation.ResourceState
import com.acostim.brastlewark.ui.main.adapter.BrastlewarkAdapter
import com.acostim.brastlewark.utils.extensions.ui.*
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainFragment : Fragment(R.layout.main_fragment),
    BrastlewarkAdapter.OnGnomeClickListener {

    private lateinit var binding: MainFragmentBinding
    private lateinit var adapter: BrastlewarkAdapter
    private val viewModel by activityViewModels<BrastlewarkViewModel>()

    private var gnomeList = emptyList<Gnome>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        adapter = BrastlewarkAdapter(requireContext(), this)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureLayout(view)
        configureSearchView()

        setObservers()

        if (gnomeList.isEmpty()) {
            viewModel.setResourceState(ResourceState.GetBrastlewarkPopulation)
        }

    }

    private fun configureLayout(view: View) {
        binding = MainFragmentBinding.bind(view)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

    private fun configureSearchView() {
        binding.searchView.onQueryTextChanged {
            viewModel.setResourceState(ResourceState.GetFilteredBrastlewarkPopulation(it, gnomeList))
        }
    }

    private fun setObservers() {
        viewModel.resourceState.observe(viewLifecycleOwner, { result ->

            binding.progressBar.showIf { result is Resource.Loading }

            when (result) {

                is Resource.Loading -> {
                    binding.emptyContainer.root.hide()
                }

                is Resource.Success -> {
                    gnomeList = result.data
                    adapter.setGnomeList(gnomeList)

                }
                is Resource.FilteredGnomes -> {
                    if(result.data.isEmpty()) {
                        adapter.setGnomeList(result.data)
                        binding.recyclerView.hide()
                        binding.emptyContainer.root.show()
                    } else {
                        adapter.setGnomeList(result.data)
                        binding.recyclerView.show()
                        binding.emptyContainer.root.hide()
                    }
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
