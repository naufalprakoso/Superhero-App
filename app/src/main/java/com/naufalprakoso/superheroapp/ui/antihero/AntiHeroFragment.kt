package com.naufalprakoso.superheroapp.ui.antihero

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.naufalprakoso.superheroapp.R
import com.naufalprakoso.superheroapp.viewmodel.ViewModelFactory
import com.naufalprakoso.superheroapp.vo.Status
import kotlinx.android.synthetic.main.fragment_anti_hero.*
import javax.inject.Inject

class AntiHeroFragment : Fragment() {

    private lateinit var adapter: AntiHeroAdapter
    private var viewModel: AntiHeroViewModel? = null

    @Inject
    @JvmField
    var factory: ViewModelProvider.Factory? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_anti_hero, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            viewModel = obtainViewModel(activity)

            if (context != null && viewModel != null) {
                adapter = AntiHeroAdapter(context!!) {
                    TODO("Intent to Hero Detail")
                }
                adapter.setHasStableIds(true)

                rvAntiHeroes.setHasFixedSize(true)
                rvAntiHeroes.setItemViewCacheSize(10)
                rvAntiHeroes.layoutManager = GridLayoutManager(context, 2)
                rvAntiHeroes.adapter = adapter
                rvAntiHeroes.isNestedScrollingEnabled = false

                viewModel!!.getAntiHeroes()?.observe(viewLifecycleOwner, Observer {
                    when (it.status) {
                        Status.LOADING -> {
                            shimmerLoading.apply {
                                visibility = View.VISIBLE
                                startShimmer()
                            }
                        }
                        Status.SUCCESS -> {
                            shimmerLoading.apply {
                                stopShimmer()
                                visibility = View.GONE
                            }

                            val data = it.data
                            if (!data.isNullOrEmpty()) {
                                adapter.setAntiHeroes(data)
                                adapter.submitList(data)
                                adapter.notifyDataSetChanged()
                            }
                        }
                        Status.ERROR -> {
                            Toast.makeText(context, getString(R.string.msg_check_connection), Toast.LENGTH_SHORT).show()
                            shimmerLoading.apply {
                                stopShimmer()
                                visibility = View.GONE
                            }
                        }
                    }
                })
            }
        }
    }

    private fun obtainViewModel(activity: FragmentActivity?): AntiHeroViewModel? {
        factory = activity?.application?.let { ViewModelFactory.getInstance(it) }
        return activity?.let { ViewModelProvider(it, factory!!).get(AntiHeroViewModel::class.java) }
    }

    companion object {
        fun getInstance(): Fragment = AntiHeroFragment()
    }

}
