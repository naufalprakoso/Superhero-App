package com.naufalprakoso.superheroapp.ui.detail.work

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.naufalprakoso.superheroapp.R
import com.naufalprakoso.superheroapp.data.source.local.entity.Work
import kotlinx.android.synthetic.main.fragment_work.*

class WorkFragment(private val work: Work) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_work, container, false)
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
