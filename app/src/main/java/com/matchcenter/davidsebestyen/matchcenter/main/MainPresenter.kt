package com.matchcenter.davidsebestyen.matchcenter.main

import android.util.Log
import com.matchcenter.davidsebestyen.matchcenter.data.Match

class MainPresenter(val view: MainContract.View, val matchFromApi: MainContract.GetMatchFromApi): MainContract.Presenter, MainContract.GetMatchFromApi.OnFinishedListener {

    var mMatch: Match? = null

    override fun onFinished(match: Match) {
        view.hideLoadingProgress()
        view.showMatchPanel()
        mMatch = match
        view.bindData()
    }

    override fun onFailure(t: Throwable) {
        view.hideMatchPanel()
        view.hideLoadingProgress()
        view.showLoadingErrorMessage()
    }

    override fun requestDataFromServer() {
        view.showLoadingProgress()
        matchFromApi.getMatch(this)
    }


}