package com.naufalprakoso.superheroapp.ui.antihero

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.naufalprakoso.superheroapp.R
import com.naufalprakoso.superheroapp.SuperheroApplication
import com.naufalprakoso.superheroapp.databinding.FragmentAntiHeroBinding
import com.naufalprakoso.superheroapp.ui.detail.HeroDetailActivity
import com.naufalprakoso.superheroapp.util.HERO_ID
import com.naufalprakoso.superheroapp.vo.Status
import javax.inject.Inject

class AntiHeroFragment : Fragment() {

    private lateinit var adapter: AntiHeroAdapter
    private lateinit var viewModel: AntiHeroViewModel

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private var _binding: FragmentAntiHeroBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAntiHeroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            inject()

            if (context != null) {
                adapter = AntiHeroAdapter(context!!) { heroId ->
                    val intent = Intent(context, HeroDetailActivity::class.java)
                    intent.putExtra(HERO_ID, heroId)
                    startActivity(intent)
                }
                adapter.setHasStableIds(true)

                binding.rvAntiHeroes.setHasFixedSize(true)
                binding.rvAntiHeroes.setItemViewCacheSize(10)
                binding.rvAntiHeroes.layoutManager = GridLayoutManager(context, 2)
                binding.rvAntiHeroes.adapter = adapter
                binding.rvAntiHeroes.isNestedScrollingEnabled = false

                viewModel.getAntiHeroes()?.observe(viewLifecycleOwner, Observer {
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
                                adapter.setAntiHeroes(data)
                                adapter.submitList(data)
                                adapter.notifyDataSetChanged()
                            }
                        }
                        Status.ERROR -> {
                            Toast.makeText(context, getString(R.string.msg_check_connection), Toast.LENGTH_SHORT).show()
                            binding.shimmerLoading.apply {
                                stopShimmer()
                                visibility = View.GONE
                            }
                        }
                    }
                })
            }
        }
    }

    private fun inject() {
        (activity!!.application as SuperheroApplication).getApplicationComponent().inject(this)
        viewModel = ViewModelProvider(this, factory).get(AntiHeroViewModel::class.java)
    }

    companion object {
        fun getInstance(): Fragment = AntiHeroFragment()
    }
}
