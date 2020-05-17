package com.naufalprakoso.superheroapp.ui.detail.connection

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.naufalprakoso.superheroapp.R
import com.naufalprakoso.superheroapp.data.source.local.entity.Connection
import kotlinx.android.synthetic.main.fragment_connection.*

class ConnectionFragment(private val connection: Connection) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_connection, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            tvGroupAffiliation.text = connection.groupAffiliation
            tvRelatives.text = connection.relatives
        }
    }

    companion object {
        fun getInstance(connection: Connection): Fragment = ConnectionFragment(connection)
    }
}
