package com.acostim.brastlewark.utils.extensions.glide

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import java.net.URL


fun ImageView.load(url: String, op: (RequestBuilder<*>) -> Unit = {}) {
    Glide.with(this).load(glideUrl(url)).also { op(it) }.into(this)
}

//based on https://github.com/bumptech/glide/issues/546
// https://stackoverflow.com/questions/66284817/glide-unable-to-load-url-images-of-this-type
fun glideUrl(thumbnailURL: String): GlideUrl {
    val USER_AGENT =
        "Mozilla/5.0 (Linux; Android 11) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.181 Mobile Safari/537.36"

    return GlideUrl(
        URL(thumbnailURL),
        LazyHeaders.Builder().addHeader("User-Agent", USER_AGENT).build()
    )

}

