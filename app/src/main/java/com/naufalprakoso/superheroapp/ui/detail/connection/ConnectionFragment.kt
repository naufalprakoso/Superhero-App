package com.naufalprakoso.superheroapp.ui.detail.connection

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.naufalprakoso.superheroapp.data.source.local.entity.Connection
import com.naufalprakoso.superheroapp.databinding.FragmentConnectionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConnectionFragment(private val connection: Connection) : Fragment() {

    private lateinit var binding: FragmentConnectionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentConnectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            binding.tvGroupAffiliation.text = connection.groupAffiliation
            binding.tvRelatives.text = connection.relatives
        }
    }

    companion object {
        fun getInstance(connection: Connection): Fragment = ConnectionFragment(connection)
    }
}
