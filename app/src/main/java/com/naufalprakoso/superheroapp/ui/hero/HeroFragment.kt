package com.naufalprakoso.superheroapp.ui.hero

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.naufalprakoso.superheroapp.R
import com.naufalprakoso.superheroapp.databinding.FragmentHeroBinding
import com.naufalprakoso.superheroapp.ui.detail.HeroDetailActivity
import com.naufalprakoso.superheroapp.util.HERO_ID
import com.naufalprakoso.superheroapp.vo.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeroFragment : Fragment() {

    private lateinit var adapter: HeroAdapter
    private val viewModel: HeroViewModel by viewModels()

    private lateinit var binding: FragmentHeroBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHeroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            if (context != null) {
                initAdapter()
                initRecyclerView()
                observeHeroes()
            }
        }
    }

    private fun initAdapter() {
        adapter = HeroAdapter(requireContext()) { heroId ->
            val intent = Intent(context, HeroDetailActivity::class.java)
            intent.putExtra(HERO_ID, heroId)
            startActivity(intent)
        }
        adapter.setHasStableIds(true)
    }

    private fun initRecyclerView() {
        binding.rvHeroes.setHasFixedSize(true)
        binding.rvHeroes.setItemViewCacheSize(10)
        binding.rvHeroes.layoutManager = GridLayoutManager(context, 2)
        binding.rvHeroes.adapter = adapter
        binding.rvHeroes.isNestedScrollingEnabled = false
    }

    private fun observeHeroes() {
        viewModel.getHeroes()?.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.LOADING -> {
                    binding.shimmerLoading.apply {
                        visibility = View.VISIBLE
                        startShimmer()
                    }
                }
                Status.SUCCESS -> {
                    binding.shimmerLoading.apply {
                        stopShimmer()
                        visibility = View.GONE
                    }

                    val data = it.data
                    if (!data.isNullOrEmpty()) {
                        adapter.setHeroes(data)
                        adapter.notifyDataSetChanged()
                    }
                }
                Status.ERROR -> {
                    Toast.makeText(activity, getString(R.string.msg_check_connection), Toast.LENGTH_SHORT).show()
                    binding.shimmerLoading.apply {
                        stopShimmer()
                        visibility = View.GONE
                    }
                }
            }
        })
    }

    companion object {
        fun getInstance(): Fragment = HeroFragment()
    }
}
