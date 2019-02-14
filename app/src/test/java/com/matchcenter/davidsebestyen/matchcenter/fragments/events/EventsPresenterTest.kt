package com.matchcenter.davidsebestyen.matchcenter.fragments.events

import org.junit.Before
import org.junit.Test

import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class EventsPresenterTest {

    lateinit var mPresenter: EventsPresenter

    @Mock
    lateinit var mView: EventsContract.View

    @Mock
    lateinit var mApi: EventsContract.GetEventsFromApi

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        mPresenter = EventsPresenter(mView, mApi)
    }

    @Test
    fun onFinished() {

        mPresenter.onFinished(listOf())

        verify(mView).hideProgress()
        verify(mView).setUpRecyclerView(listOf())
    }

    @Test
    fun onFailure() {
        mPresenter.onFailure(t = Throwable())
        verify(mView).hideProgress()
        verify(mView).showErrorMessage()

    }

    @Test
    fun requestDataFromServer() {
        mPresenter.requestDataFromServer()

        verify(mApi).getEvents(mPresenter)
        verify(mView).showProgress()

    }
}