package com.matchcenter.davidsebestyen.matchcenter.fragments.events

import android.util.Log
import com.matchcenter.davidsebestyen.matchcenter.data.MatchEvent

class EventsPresenter(val view: EventsContract.View, val eventsFromApi: EventsContract.GetEventsFromApi): EventsContract.Presenter, EventsContract.GetEventsFromApi.OnFinishedListener {
    override fun onFinished(events: List<MatchEvent>) {
        view.hideProgress()
        view.setUpRecyclerView(events)
    }

    override fun onFailure(t: Throwable) {
        view.hideProgress()
        view.showErrorMessage()
    }

    override fun requestDataFromServer() {
        view.showProgress()
        eventsFromApi.getEvents(this)
    }


}