package com.naufalprakoso.superheroapp.ui.detail.appearance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.naufalprakoso.superheroapp.data.source.local.entity.Appearance
import com.naufalprakoso.superheroapp.databinding.FragmentAppearanceBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AppearanceFragment(private val appearance: Appearance) : Fragment() {

    private lateinit var binding: FragmentAppearanceBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAppearanceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            binding.tvGender.text = appearance.gender
            binding.tvRace.text = appearance.getRace
            binding.tvHeight.text = appearance.height
            binding.tvWeight.text = appearance.weight
            binding.tvEyeColor.text = appearance.eyeColor
            binding.tvHairColor.text = appearance.hairColor
        }
    }

    companion object {
        fun getInstance(appearance: Appearance): Fragment = AppearanceFragment(appearance)
    }
}
