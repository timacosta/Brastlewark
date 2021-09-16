package com.acostim.brastlewark.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acostim.brastlewark.R
import com.acostim.brastlewark.databinding.GnomeItemBinding
import com.acostim.brastlewark.network.BrastlewarkNetwork
import com.acostim.brastlewark.network.GnomeNetworkModel
import com.bumptech.glide.Glide

class BrastlewarkAdapter: RecyclerView.Adapter<BrastlewarkViewHolder>() {

    var brastlewarkCity: BrastlewarkNetwork = BrastlewarkNetwork(emptyList())
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrastlewarkViewHolder =
        GnomeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            .run { BrastlewarkViewHolder(this) }


    override fun onBindViewHolder(holder: BrastlewarkViewHolder, position: Int) {
        val gnome: GnomeNetworkModel = brastlewarkCity.brastlewark[position]
        holder.bind(gnome)
    }

    override fun getItemCount(): Int = brastlewarkCity.brastlewark.size


}
data class BrastlewarkViewHolder(val binding: GnomeItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(gnome: GnomeNetworkModel) {
        with(binding) {
            tvName.text = gnome.name
            tvFriendsCount.text = "${gnome.friends.size}"
            tvProfessionsCount.text = "${gnome.professions.size}"

            avatarImageView.setImageBitmap(null)
            Glide.with(root)
                .load(gnome.thumbnail)
                .into(avatarImageView)

            if(gnome.thumbnail.isNullOrBlank()) {
                avatarImageView.setImageResource(R.drawable.gnome_image)
            }

        }
    }
}
