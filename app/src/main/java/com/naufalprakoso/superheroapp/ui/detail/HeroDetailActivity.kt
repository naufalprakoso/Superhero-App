package com.naufalprakoso.superheroapp.ui.detail

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.naufalprakoso.superheroapp.R
import com.naufalprakoso.superheroapp.util.HERO_ID
import com.naufalprakoso.superheroapp.util.UtilUi
import com.naufalprakoso.superheroapp.viewmodel.ViewModelFactory
import com.naufalprakoso.superheroapp.vo.Status
import kotlinx.android.synthetic.main.activity_hero_detail.*
import kotlinx.android.synthetic.main.layout_hero_detail_header.*
import javax.inject.Inject

class HeroDetailActivity : AppCompatActivity() {

    private var viewModel: HeroDetailViewModel? = null

    @Inject
    @JvmField
    var factory: ViewModelProvider.Factory? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tabTitles = arrayOf(
            getString(R.string.title_tab_biography),
            getString(R.string.title_tab_power_stats),
            getString(R.string.title_tab_appearance),
            getString(R.string.title_tab_work),
            getString(R.string.title_tab_connection)
        )

        tabLayout.apply {
            tabGravity = TabLayout.GRAVITY_FILL

            addTab(tabLayout.newTab().setText(getString(R.string.title_tab_biography)))
            addTab(tabLayout.newTab().setText(getString(R.string.title_tab_power_stats)))
            addTab(tabLayout.newTab().setText(getString(R.string.title_tab_appearance)))
            addTab(tabLayout.newTab().setText(getString(R.string.title_tab_work)))
            addTab(tabLayout.newTab().setText(getString(R.string.title_tab_connection)))

            setTabTextColors(
                ContextCompat.getColor(applicationContext, R.color.textUnselected),
                ContextCompat.getColor(applicationContext, R.color.textSelected)
            )

            addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    viewPager.currentItem = tab.position
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {}
                override fun onTabReselected(tab: TabLayout.Tab) {}
            })
        }

        val heroId = intent?.getLongExtra(HERO_ID, -1)
        viewModel = obtainViewModel(this)

        if ((heroId != null && heroId >= 0) && viewModel != null) {
            viewModel?.heroId = heroId
            viewModel?.getHeroDetail()?.observe(this, Observer { resources ->
                when (resources.status) {
                    Status.LOADING -> {
                        shimmerLoading.apply {
                            startShimmer()
                        }
                    }
                    Status.SUCCESS -> {
                        val hero = resources?.data

                        shimmerLoading.apply {
                            stopShimmer()
                            visibility = View.GONE
                        }
                        layoutMain.visibility = View.VISIBLE

                        if (hero != null) {
                            supportActionBar?.title = hero.hero.name

                            Glide.with(this).asBitmap().apply(UtilUi.imageHero()).load(hero.image.lg).into(ivHero)
                            tvName.text = hero.hero.name
                            tvRace.text = hero.appearance.getRace

                            val tabsAdapter = HeroDetailTabsAdapter(this, hero, tabLayout.tabCount)
                            viewPager.adapter = tabsAdapter
                            TabLayoutMediator(tabLayout, viewPager) { tab, position -> tab.text = tabTitles[position] }.attach()
                        }
                    }
                    Status.ERROR -> {
                        Toast.makeText(this, getString(R.string.msg_check_connection), Toast.LENGTH_SHORT).show()
                        shimmerLoading.apply {
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

    private fun obtainViewModel(activity: Activity?): HeroDetailViewModel? {
        factory = activity?.application?.let { ViewModelFactory.getInstance(it) }
        return factory?.let { ViewModelProvider(this, it).get(HeroDetailViewModel::class.java) }
    }
}
