package com.matchcenter.davidsebestyen.matchcenter.main

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.matchcenter.davidsebestyen.matchcenter.R
import com.matchcenter.davidsebestyen.matchcenter.adapter.MatchDetailsViewPagerAdapter
import com.matchcenter.davidsebestyen.matchcenter.data.Player
import com.matchcenter.davidsebestyen.matchcenter.databinding.ActivityMainBinding
import com.matchcenter.davidsebestyen.matchcenter.fragments.events.EventsFragment
import com.matchcenter.davidsebestyen.matchcenter.fragments.lineup.LineUpFragment
import com.matchcenter.davidsebestyen.matchcenter.fragments.stats.StatsFragment

class MainActivity : AppCompatActivity(), MainContract.View {

    lateinit var mainPresenter: MainPresenter
    lateinit var binding: ActivityMainBinding
    lateinit var viewPagerAdapter: MatchDetailsViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainPresenter = MainPresenter(this, GetMatchFromApiImpl())
        viewPagerAdapter = MatchDetailsViewPagerAdapter(supportFragmentManager)
        mainPresenter.requestDataFromServer()
    }

    //binding the view with data
    override fun bindData() {
        binding.match = mainPresenter.mMatch
        if(binding.match != null) {
            setUpFragmentPagerAdapter()
        }
    }

    //setting up the viewpager for mathc details
    fun setUpFragmentPagerAdapter() {

        viewPagerAdapter.addFragment(EventsFragment.newInstance())
        viewPagerAdapter.addFragment(LineUpFragment.newInstance(mainPresenter.mMatch!!.home.team as ArrayList<Player>, mainPresenter.mMatch!!.away.team as ArrayList<Player>))
        viewPagerAdapter.addFragment(StatsFragment.newInstance(mainPresenter.mMatch!!.homeStats, mainPresenter.mMatch!!.awayStats))

        binding.matchVp.adapter = viewPagerAdapter
        binding.matchVp.offscreenPageLimit = 2
        binding.tabs.setupWithViewPager(binding.matchVp)

    }


    // methods for showing progress view and display an error toast if we cannot load data
    override fun showLoadingErrorMessage() {
        binding.matchContainer.visibility = View.GONE
        Toast.makeText(this, R.string.network_error_msg, Toast.LENGTH_LONG).show()
    }

    override fun showLoadingProgress() {
        binding.progress.visibility = View.VISIBLE
    }

    override fun hideLoadingProgress() {
        binding.progress.visibility = View.GONE
    }

    override fun hideMatchPanel() {
        binding.matchContainer.visibility = View.INVISIBLE
    }

    override fun showMatchPanel() {
        binding.matchContainer.visibility = View.VISIBLE
    }

}
