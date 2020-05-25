package com.naufalprakoso.superheroapp.ui.villain

import android.content.Intent
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
import com.naufalprakoso.superheroapp.databinding.FragmentVillainBinding
import com.naufalprakoso.superheroapp.ui.detail.HeroDetailActivity
import com.naufalprakoso.superheroapp.util.HERO_ID
import com.naufalprakoso.superheroapp.viewmodel.ViewModelFactory
import com.naufalprakoso.superheroapp.vo.Status
import javax.inject.Inject

class VillainFragment : Fragment() {

    private lateinit var adapter: VillainAdapter
    private var viewModel: VillainViewModel? = null

    @Inject
    @JvmField
    var factory: ViewModelProvider.Factory? = null

    private var _binding: FragmentVillainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentVillainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            viewModel = obtainViewModel(activity)

            if (context != null && viewModel != null) {
                adapter = VillainAdapter(context!!) { heroId ->
                    val intent = Intent(context, HeroDetailActivity::class.java)
                    intent.putExtra(HERO_ID, heroId)
                    startActivity(intent)
                }
                adapter.setHasStableIds(true)

                binding.rvVillains.setHasFixedSize(true)
                binding.rvVillains.setItemViewCacheSize(10)
                binding.rvVillains.layoutManager = GridLayoutManager(context, 2)
                binding.rvVillains.adapter = adapter
                binding.rvVillains.isNestedScrollingEnabled = false

                viewModel!!.getVillains()?.observe(viewLifecycleOwner, Observer {
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
                                adapter.setVillains(data)
                                adapter.submitList(data)
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
        }
    }

    private fun obtainViewModel(activity: FragmentActivity?): VillainViewModel? {
        factory = activity?.application?.let { ViewModelFactory.getInstance(it) }
        return activity?.let { ViewModelProvider(it, factory!!).get(VillainViewModel::class.java) }
    }

    companion object {
        fun getInstance(): Fragment = VillainFragment()
    }
}
