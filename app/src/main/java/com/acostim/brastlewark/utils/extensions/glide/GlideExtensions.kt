package com.acostim.brastlewark.utils.extensions.glide

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder

class GlideExtensions {

    fun ImageView.load(url: String, op: (RequestBuilder<*>) -> Unit = {}) {
        Glide.with(this).load(url).also { op(it) }.into(this)
    }

}