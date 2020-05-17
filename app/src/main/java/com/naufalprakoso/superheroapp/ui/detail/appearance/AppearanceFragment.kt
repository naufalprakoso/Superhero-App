package com.naufalprakoso.superheroapp.ui.detail.appearance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.naufalprakoso.superheroapp.R
import com.naufalprakoso.superheroapp.data.source.local.entity.Appearance
import kotlinx.android.synthetic.main.fragment_appearance.*

class AppearanceFragment(private val appearance: Appearance) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_appearance, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            tvGender.text = appearance.gender
            tvRace.text = appearance.getRace
            tvHeight.text = appearance.height
            tvWeight.text = appearance.weight
            tvEyeColor.text = appearance.eyeColor
            tvHairColor.text = appearance.hairColor
        }
    }

    companion object {
        fun getInstance(appearance: Appearance): Fragment = AppearanceFragment(appearance)
    }
}
