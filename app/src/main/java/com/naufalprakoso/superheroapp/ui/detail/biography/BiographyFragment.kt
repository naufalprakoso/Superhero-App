package com.naufalprakoso.superheroapp.ui.detail.biography

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.naufalprakoso.superheroapp.data.source.local.entity.Biography
import com.naufalprakoso.superheroapp.databinding.FragmentBiographyBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BiographyFragment(private val biography: Biography) : Fragment() {

    private var _binding: FragmentBiographyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBiographyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            binding.tvFullName.text = biography.fullName
            binding.tvPlaceOfBirth.text = biography.placeOfBirth
            binding.tvFirstAppearance.text = biography.firstAppearance
            binding.tvAlterEgos.text = biography.alterEgos
            binding.tvAliases.text = biography.aliases
            binding.tvPublisher.text = biography.publisher
        }
    }

    companion object {
        fun getInstance(biography: Biography): Fragment = BiographyFragment(biography)
    }
}
