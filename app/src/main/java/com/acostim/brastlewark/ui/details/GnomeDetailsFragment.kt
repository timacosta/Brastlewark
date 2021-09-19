package com.acostim.brastlewark.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import com.acostim.brastlewark.R
import com.acostim.brastlewark.data.model.Gnome
import com.acostim.brastlewark.databinding.FragmentGnomeDetailsBinding
import com.acostim.brastlewark.databinding.MainFragmentBinding
import com.acostim.brastlewark.presentation.BrastlewarkViewModel
import com.acostim.brastlewark.utils.extensions.glide.load
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GnomeDetailsFragment : Fragment(R.layout.fragment_gnome_details) {

    private lateinit var binding: FragmentGnomeDetailsBinding
    private val viewModel by activityViewModels<BrastlewarkViewModel>()

    private lateinit var gnome: Gnome

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireArguments().let {
            GnomeDetailsFragmentArgs.fromBundle(it).also { args ->
                gnome = args.gnome
            }
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).supportActionBar?.title = gnome.name

        binding = FragmentGnomeDetailsBinding.bind(view)

        binding.ivGnomeDetail.load(gnome.thumbnail) {
            it.centerCrop()
        }

        binding.tvAge.text = gnome.age.toString()
        binding.tvWeight.text = gnome.weight.toString()
        binding.tvHeight.text = gnome.height.toString()
        binding.tvHairColor.text = gnome.hair_color
        binding.tvProfessions.text = gnome.professions.toString().removePrefix("[").removeSuffix("]")
        binding.tvFriends.text = gnome.friends.toString().removePrefix("[").removeSuffix("]")

    }

}