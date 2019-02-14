package com.matchcenter.davidsebestyen.matchcenter.fragments.events

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import com.matchcenter.davidsebestyen.matchcenter.R
import com.matchcenter.davidsebestyen.matchcenter.adapter.MatchEventsAdapter
import com.matchcenter.davidsebestyen.matchcenter.data.MatchEvent
import java.util.*

class EventsFragment: Fragment(), EventsContract.View {


    companion object {
        fun newInstance(): EventsFragment {
            return EventsFragment()
        }
    }

    lateinit var mPresenter: EventsPresenter
    lateinit var mRecyclerView: RecyclerView

    lateinit var mProgress: ProgressBar

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_events, container, false)

        mRecyclerView = view.findViewById(R.id.events_rv)
        mProgress = view.findViewById(R.id.progress)

        mPresenter = EventsPresenter(this, GetMatchEventsFromApi())
        mPresenter.requestDataFromServer()

        return view
    }


    override fun setUpRecyclerView(eventsList: List<MatchEvent>) {
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mRecyclerView.setHasFixedSize(true)

        Collections.reverse(eventsList)

        mRecyclerView.adapter = MatchEventsAdapter(context!!, eventsList)
    }

    override fun hideProgress() {
        mProgress.visibility = View.GONE
    }

    override fun showProgress() {
        mProgress.visibility = View.VISIBLE

    }

    override fun showErrorMessage() {
        Toast.makeText(context, R.string.network_error_msg, Toast.LENGTH_LONG).show()    }

}