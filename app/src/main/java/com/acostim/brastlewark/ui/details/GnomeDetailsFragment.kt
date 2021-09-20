package com.acostim.brastlewark.ui.details

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.acostim.brastlewark.R
import com.acostim.brastlewark.data.model.Gnome
import com.acostim.brastlewark.databinding.FragmentGnomeDetailsBinding
import com.acostim.brastlewark.utils.extensions.glide.load
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GnomeDetailsFragment : Fragment(R.layout.fragment_gnome_details) {

    private lateinit var binding: FragmentGnomeDetailsBinding
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
        binding.tvWeight.text = gnome.weight.toString().dropLast(4) ?: "N/A"
        binding.tvHeight.text = gnome.height.toString().dropLast(4)
        binding.tvHairColor.text = gnome.hairColor

        if(gnome.professions.isEmpty()) {
            binding.tvProfessions.text = "Unemployed"
        } else {
            binding.tvProfessions.text = gnome.professions.toString().removePrefix("[").removeSuffix("]")
        }

        if(gnome.friends.isEmpty()) {
            binding.tvFriends.text = "Introvert"
        } else {
            binding.tvFriends.text = gnome.friends.toString().removePrefix("[").removeSuffix("]")
        }

    }

}