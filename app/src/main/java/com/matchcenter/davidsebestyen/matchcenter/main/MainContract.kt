package com.matchcenter.davidsebestyen.matchcenter.main

import android.service.autofill.FieldClassification
import com.matchcenter.davidsebestyen.matchcenter.data.Match

interface MainContract {

    interface View {

        fun showLoadingProgress()

        fun hideLoadingProgress()

        fun showLoadingErrorMessage()

        fun hideMatchPanel()

        fun showMatchPanel()

        fun bindData()

    }

    interface Presenter {

        fun requestDataFromServer()

    }

    interface GetMatchFromApi {

        interface OnFinishedListener {
            fun onFinished(match: Match);
            fun onFailure(t: Throwable);
        }

        fun getMatch(onFinishedListener: OnFinishedListener);

    }

}