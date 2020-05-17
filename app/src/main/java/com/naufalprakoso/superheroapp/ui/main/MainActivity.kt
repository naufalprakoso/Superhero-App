package com.naufalprakoso.superheroapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.naufalprakoso.superheroapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabTitles = arrayOf(
            getString(R.string.title_hero),
            getString(R.string.title_anti_hero),
            getString(R.string.title_villain)
        )

        tabLayout.apply {
            tabGravity = TabLayout.GRAVITY_FILL

            addTab(tabLayout.newTab().setText(getString(R.string.title_hero)))
            addTab(tabLayout.newTab().setText(getString(R.string.title_anti_hero)))
            addTab(tabLayout.newTab().setText(getString(R.string.title_villain)))

            setTabTextColors(
                ContextCompat.getColor(context, R.color.textUnselected),
                ContextCompat.getColor(context, R.color.textSelected)
            )

            addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    viewPager.currentItem = tab.position
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {}
                override fun onTabReselected(tab: TabLayout.Tab) {}
            })
        }

        val tabsAdapter = HomeTabsAdapter(this)
        viewPager.adapter = tabsAdapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position -> tab.text = tabTitles[position] }.attach()
    }
}
