package com.matchcenter.davidsebestyen.matchcenter.retrofit

import com.matchcenter.davidsebestyen.matchcenter.data.Match
import com.matchcenter.davidsebestyen.matchcenter.data.MatchEvent
import retrofit2.Call
import retrofit2.http.GET

interface GetRetrofitService {


    @GET("opta?pageType=match&value=803294&v=5")
    fun getMatch(): Call<Match>

    @GET("opta?pageType=matchCommentary&value=803294&v=2")
    fun getMatchEvents(): Call<List<MatchEvent>>


}