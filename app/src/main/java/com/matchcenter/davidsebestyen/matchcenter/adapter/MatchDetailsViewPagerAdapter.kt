package com.matchcenter.davidsebestyen.matchcenter.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class MatchDetailsViewPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {
    val fragmentList = ArrayList<Fragment>()


    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    fun addFragment(fragment: Fragment){
        fragmentList.add(fragment)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0 -> return "Events"
            1 -> return "Line Up"
            2 -> return "Stats"
            else -> return "N/A"
        }
    }
}