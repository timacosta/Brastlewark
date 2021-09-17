package com.acostim.brastlewark.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acostim.brastlewark.R
import com.acostim.brastlewark.data.model.Gnome
import com.acostim.brastlewark.databinding.GnomeItemBinding
import com.bumptech.glide.Glide

class BrastlewarkAdapter(
    private val context: Context,
    private val itemClickListener: OnGnomeClickListener
): RecyclerView.Adapter<BrastlewarkViewHolder>() {


    private var gnomeList = listOf<Gnome>()

    interface OnGnomeClickListener {
        fun onGnomeClick(gnome: Gnome, position: Int)
    }

    fun setGnomeList(gnomeList: List<Gnome>) {
        this.gnomeList = gnomeList
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrastlewarkViewHolder =
        GnomeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            .run { BrastlewarkViewHolder(this) }


    override fun onBindViewHolder(holder: BrastlewarkViewHolder, position: Int) {
        when(holder) {
            is BrastlewarkViewHolder -> holder.bind(gnomeList[position])
        }
    }

    override fun getItemCount(): Int = gnomeList.size


}
data class BrastlewarkViewHolder(val binding: GnomeItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(gnome: Gnome) {
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
