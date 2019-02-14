package com.matchcenter.davidsebestyen.matchcenter.main

import com.matchcenter.davidsebestyen.matchcenter.data.Match
import org.junit.Assert
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class MainPresenterTest {

    lateinit var mPresenter: MainPresenter

    @Mock
    lateinit var mView: MainContract.View

    @Mock
    lateinit var mApiContract: MainContract.GetMatchFromApi


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        mPresenter = MainPresenter(mView, mApiContract)
    }

    @Test
    fun onFinished() {
        mPresenter.onFinished(Match())

        verify(mView).hideLoadingProgress()
        verify(mView).bindData()

    }

    @Test
    fun onFailure() {
        mPresenter.onFailure(t = Throwable())

        verify(mView).hideLoadingProgress()
        verify(mView).showLoadingErrorMessage()
    }

    @Test
    fun requestDataFromServer() {
        mPresenter.requestDataFromServer()

        verify(mView).showLoadingProgress()
        verify(mApiContract).getMatch(mPresenter)

    }
}