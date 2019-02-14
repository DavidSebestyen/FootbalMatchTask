package com.matchcenter.davidsebestyen.matchcenter.fragments.events

import com.matchcenter.davidsebestyen.matchcenter.data.Match
import com.matchcenter.davidsebestyen.matchcenter.data.MatchEvent

interface EventsContract {

    interface View{
        fun setUpRecyclerView(eventsList: List<MatchEvent>)

        fun hideProgress()

        fun showProgress()

        fun showErrorMessage()
    }

    interface Presenter{

        fun requestDataFromServer()

    }

    interface GetEventsFromApi {

        interface OnFinishedListener {
            fun onFinished(events: List<MatchEvent>);
            fun onFailure(t: Throwable);
        }

        fun getEvents(onFinishedListener: OnFinishedListener);

    }
}