package com.naufalprakoso.superheroapp.ui.detail.biography

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.naufalprakoso.superheroapp.R
import com.naufalprakoso.superheroapp.data.source.local.entity.Biography
import kotlinx.android.synthetic.main.fragment_biography.*

class BiographyFragment(private val biography: Biography) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_biography, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            tvFullName.text = biography.fullName
            tvPlaceOfBirth.text = biography.placeOfBirth
            tvFirstAppearance.text = biography.firstAppearance
            tvAlterEgos.text = biography.alterEgos
            tvAliases.text = biography.aliases
            tvPublisher.text = biography.publisher
        }
    }

    companion object {
        fun getInstance(biography: Biography): Fragment = BiographyFragment(biography)
    }
}
