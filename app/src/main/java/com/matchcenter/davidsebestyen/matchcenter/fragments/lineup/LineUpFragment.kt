package com.matchcenter.davidsebestyen.matchcenter.fragments.lineup

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matchcenter.davidsebestyen.matchcenter.R
import com.matchcenter.davidsebestyen.matchcenter.adapter.PlayerAdapter
import com.matchcenter.davidsebestyen.matchcenter.data.Player
import com.matchcenter.davidsebestyen.matchcenter.fragments.events.EventsFragment

class LineUpFragment: Fragment(){

    companion object {
        fun newInstance(homeTeamList: ArrayList<Player>, awayTeamList: ArrayList<Player>): LineUpFragment {

            val args = Bundle()
            args.putParcelableArrayList("homeTeam",homeTeamList);
            args.putParcelableArrayList("awayTeam", awayTeamList)
            val fragment = LineUpFragment()
            fragment.arguments = args
            return fragment
        }
    }

    val homeTeamList = ArrayList<Player>()
    val awayTeamList = ArrayList<Player>()

    lateinit var homeRecyclerView: RecyclerView
    lateinit var awayRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val args = arguments
        if(args != null) {
            homeTeamList.addAll(args.getParcelableArrayList("homeTeam"))
            awayTeamList.addAll(args.getParcelableArrayList("awayTeam"))
        }


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_lineup, container, false)

        homeRecyclerView = view.findViewById(R.id.home_team_rv)
        awayRecyclerView = view.findViewById(R.id.away_team_rv)

        setUpRecyclerView()

        return view
    }

    fun setUpRecyclerView() {
        val awayLayoutManager = LinearLayoutManager(context)

        homeRecyclerView.layoutManager = LinearLayoutManager(context)

        homeRecyclerView.setHasFixedSize(true)
        homeRecyclerView.adapter = PlayerAdapter(context!!, homeTeamList)

        awayRecyclerView.layoutManager = awayLayoutManager
        awayRecyclerView.setHasFixedSize(true)
        awayRecyclerView.adapter = PlayerAdapter(context!!, awayTeamList)

    }

}
