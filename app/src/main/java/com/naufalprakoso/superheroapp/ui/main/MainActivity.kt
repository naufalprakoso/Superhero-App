package com.naufalprakoso.superheroapp.ui.main

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.naufalprakoso.superheroapp.R
import com.naufalprakoso.superheroapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val tabTitles = arrayOf(
            getString(R.string.title_hero),
            getString(R.string.title_anti_hero),
            getString(R.string.title_villain)
        )

        binding.tabLayout.apply {
            tabGravity = TabLayout.GRAVITY_FILL

            addTab(binding.tabLayout.newTab().setText(getString(R.string.title_hero)))
            addTab(binding.tabLayout.newTab().setText(getString(R.string.title_anti_hero)))
            addTab(binding.tabLayout.newTab().setText(getString(R.string.title_villain)))

            setTabTextColors(
                ContextCompat.getColor(context, R.color.textUnselected),
                ContextCompat.getColor(context, R.color.textSelected)
            )

            addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    binding.viewPager.currentItem = tab.position
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {}
                override fun onTabReselected(tab: TabLayout.Tab) {}
            })
        }

        val tabsAdapter = HomeTabsAdapter(this)
        binding.viewPager.adapter = tabsAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_theme -> {
                val mode =
                    if ((resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) ==
                            Configuration.UI_MODE_NIGHT_NO) {
                        AppCompatDelegate.MODE_NIGHT_YES
                    } else {
                        AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY
                    }

                AppCompatDelegate.setDefaultNightMode(mode)
                true
            }
            else -> true
        }
    }
}
