package com.naufalprakoso.superheroapp.ui.detail.powerstats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.naufalprakoso.superheroapp.database.entity.PowerStat
import com.naufalprakoso.superheroapp.databinding.FragmentPowerStatsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PowerStatsFragment(private val powerStat: PowerStat) : Fragment() {

    private lateinit var binding: FragmentPowerStatsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPowerStatsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            binding.tvIntelligence.text = powerStat.intelligence.toString()
            binding.tvCombat.text = powerStat.combat.toString()
            binding.tvPower.text = powerStat.power.toString()
            binding.tvSpeed.text = powerStat.speed.toString()
            binding.tvStrength.text = powerStat.strength.toString()
            binding.tvDurability.text = powerStat.durability.toString()
        }
    }

    companion object {
        fun getInstance(powerStat: PowerStat): Fragment = PowerStatsFragment(powerStat)
    }
}
