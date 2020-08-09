package com.naufalprakoso.superheroapp.ui.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.naufalprakoso.superheroapp.R
import com.naufalprakoso.superheroapp.databinding.ActivityHeroDetailBinding
import com.naufalprakoso.superheroapp.util.HERO_ID
import com.naufalprakoso.superheroapp.util.UtilUi
import com.naufalprakoso.superheroapp.vo.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeroDetailActivity : AppCompatActivity() {

    private val viewModel: HeroDetailViewModel by viewModels()

    private lateinit var binding: ActivityHeroDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroDetailBinding.inflate(layoutInflater)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initTabLayout()
        observeHeroDetail()

        setContentView(binding.root)
    }

    private fun initTabLayout() {
        binding.tabLayout.apply {
            tabGravity = TabLayout.GRAVITY_FILL

            addTab(binding.tabLayout.newTab().setText(getString(R.string.title_tab_biography)))
            addTab(binding.tabLayout.newTab().setText(getString(R.string.title_tab_power_stats)))
            addTab(binding.tabLayout.newTab().setText(getString(R.string.title_tab_appearance)))
            addTab(binding.tabLayout.newTab().setText(getString(R.string.title_tab_work)))
            addTab(binding.tabLayout.newTab().setText(getString(R.string.title_tab_connection)))

            setTabTextColors(
                ContextCompat.getColor(applicationContext, R.color.textUnselected),
                ContextCompat.getColor(applicationContext, R.color.textSelected)
            )

            addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    binding.viewPager.currentItem = tab.position
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {}
                override fun onTabReselected(tab: TabLayout.Tab) {}
            })
        }
    }

    private fun observeHeroDetail() {
        val heroId = intent?.getLongExtra(HERO_ID, -1)
        if (heroId != null && heroId >= 0) {
            viewModel.getHeroDetail(heroId)?.observe(this, Observer { resources ->
                when (resources.status) {
                    Status.LOADING -> {
                        binding.shimmerLoading.apply {
                            startShimmer()
                        }
                    }
                    Status.SUCCESS -> {
                        val hero = resources?.data

                        binding.shimmerLoading.apply {
                            stopShimmer()
                            visibility = View.GONE
                        }
                        binding.layoutMain.visibility = View.VISIBLE

                        if (hero != null) {
                            val tabTitles = arrayOf(
                                getString(R.string.title_tab_biography),
                                getString(R.string.title_tab_power_stats),
                                getString(R.string.title_tab_appearance),
                                getString(R.string.title_tab_work),
                                getString(R.string.title_tab_connection)
                            )

                            supportActionBar?.title = hero.hero.name

                            Glide.with(this).asBitmap().apply(UtilUi.imageHero())
                                .load(hero.image.lg).into(binding.layoutHeader.ivHero)
                            binding.layoutHeader.tvName.text = hero.hero.name
                            binding.layoutHeader.tvRace.text = hero.appearance.getRace

                            val tabsAdapter =
                                HeroDetailTabsAdapter(this, hero, binding.tabLayout.tabCount)
                            binding.viewPager.adapter = tabsAdapter
                            TabLayoutMediator(
                                binding.tabLayout,
                                binding.viewPager
                            ) { tab, position -> tab.text = tabTitles[position] }.attach()
                        }
                    }
                    Status.ERROR -> {
                        Toast.makeText(
                            this,
                            getString(R.string.msg_check_connection),
                            Toast.LENGTH_SHORT
                        ).show()
                        binding.shimmerLoading.apply {
                            stopShimmer()
                        }
                    }
                }
            })
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
