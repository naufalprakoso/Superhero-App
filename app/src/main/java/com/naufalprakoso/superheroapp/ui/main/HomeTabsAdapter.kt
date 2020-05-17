package com.naufalprakoso.superheroapp.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.naufalprakoso.superheroapp.ui.antihero.AntiHeroFragment
import com.naufalprakoso.superheroapp.ui.hero.HeroFragment
import com.naufalprakoso.superheroapp.ui.villain.VillainFragment

class HomeTabsAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HeroFragment.getInstance()
            1 -> AntiHeroFragment.getInstance()
            else -> VillainFragment.getInstance()
        }
    }
}