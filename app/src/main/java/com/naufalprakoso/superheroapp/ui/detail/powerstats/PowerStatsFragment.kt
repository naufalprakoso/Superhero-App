package com.naufalprakoso.superheroapp.ui.detail.powerstats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.naufalprakoso.superheroapp.data.source.local.entity.PowerStat
import com.naufalprakoso.superheroapp.databinding.FragmentPowerStatsBinding

class PowerStatsFragment(private val powerStat: PowerStat) : Fragment() {

    private var _binding: FragmentPowerStatsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPowerStatsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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
