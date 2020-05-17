package com.naufalprakoso.superheroapp.util

import androidx.fragment.app.Fragment
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.naufalprakoso.superheroapp.ui.hero.HeroFragment

object UtilUi {
    var CURRENT_FRAGMENT: Fragment = HeroFragment.getInstance()

    fun imageHero(): RequestOptions = RequestOptions()
        .centerCrop()
        .diskCacheStrategy(DiskCacheStrategy.ALL)
}