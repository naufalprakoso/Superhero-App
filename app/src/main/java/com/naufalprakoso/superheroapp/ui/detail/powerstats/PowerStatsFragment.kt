package com.naufalprakoso.superheroapp.ui.detail.powerstats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.naufalprakoso.superheroapp.R
import com.naufalprakoso.superheroapp.data.source.local.entity.PowerStat
import kotlinx.android.synthetic.main.fragment_power_stats.*

class PowerStatsFragment(private val powerStat: PowerStat) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_power_stats, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            tvIntelligence.text = powerStat.intelligence.toString()
            tvCombat.text = powerStat.combat.toString()
            tvPower.text = powerStat.power.toString()
            tvSpeed.text = powerStat.speed.toString()
            tvStrength.text = powerStat.strength.toString()
            tvDurability.text = powerStat.durability.toString()
        }
    }

    companion object {
        fun getInstance(powerStat: PowerStat): Fragment = PowerStatsFragment(powerStat)
    }
}
