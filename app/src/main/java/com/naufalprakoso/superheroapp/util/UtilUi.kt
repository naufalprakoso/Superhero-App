package com.naufalprakoso.superheroapp.util

import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

object UtilUi {

    fun imageHero(): RequestOptions = RequestOptions()
        .centerCrop()
        .diskCacheStrategy(DiskCacheStrategy.ALL)
}