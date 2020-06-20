package com.naufalprakoso.superheroapp.ui.detail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.naufalprakoso.superheroapp.database.relation.Superhero
import com.naufalprakoso.superheroapp.ui.detail.appearance.AppearanceFragment
import com.naufalprakoso.superheroapp.ui.detail.biography.BiographyFragment
import com.naufalprakoso.superheroapp.ui.detail.powerstats.PowerStatsFragment
import com.naufalprakoso.superheroapp.ui.detail.work.WorkFragment
import com.naufalprakoso.superheroapp.ui.detail.connection.ConnectionFragment

class HeroDetailTabsAdapter(
    fa: FragmentActivity,
    var superhero: Superhero,
    private var mNumOfTabs: Int
) : FragmentStateAdapter(fa) {

    override fun getItemCount(): Int = mNumOfTabs

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> BiographyFragment.getInstance(superhero.biography)
            1 -> PowerStatsFragment.getInstance(superhero.powerStat)
            2 -> AppearanceFragment.getInstance(superhero.appearance)
            3 -> WorkFragment.getInstance(superhero.work)
            else -> ConnectionFragment.getInstance(superhero.connection)
        }
    }
}