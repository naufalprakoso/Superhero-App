package com.naufalprakoso.superheroapp.ui.detail.work

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.naufalprakoso.superheroapp.data.source.local.entity.Work
import com.naufalprakoso.superheroapp.databinding.FragmentWorkBinding
import kotlinx.android.synthetic.main.fragment_work.*

class WorkFragment(private val work: Work) : Fragment() {

    private var _binding: FragmentWorkBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWorkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            tvOccupation.text = work.occupation
            tvBase.text = work.base
        }
    }

    companion object {
        fun getInstance(work: Work): Fragment = WorkFragment(work)
    }
}
