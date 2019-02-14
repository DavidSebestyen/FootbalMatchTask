package com.matchcenter.davidsebestyen.matchcenter.fragments.stats

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matchcenter.davidsebestyen.matchcenter.R
import com.matchcenter.davidsebestyen.matchcenter.data.Stats
import com.matchcenter.davidsebestyen.matchcenter.databinding.FragmentStatsBinding

class StatsFragment: Fragment() {
    companion object {
        fun newInstance(homeStats: Stats, awayStats: Stats): StatsFragment {
            val args = Bundle()
            val fragment = StatsFragment()

            args.putParcelable("homeStats", homeStats)
            args.putParcelable("awayStats", awayStats)

            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentStatsBinding>(inflater, R.layout.fragment_stats, container, false)

        binding.homeStats = arguments?.getParcelable("homeStats")
        binding.awayStats = arguments?.getParcelable("awayStats")

        return binding.root
    }
}