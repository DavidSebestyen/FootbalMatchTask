package com.matchcenter.davidsebestyen.matchcenter.fragments.events

import android.util.Log
import com.matchcenter.davidsebestyen.matchcenter.data.MatchEvent
import com.matchcenter.davidsebestyen.matchcenter.retrofit.GetRetrofitService
import com.matchcenter.davidsebestyen.matchcenter.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetMatchEventsFromApi: EventsContract.GetEventsFromApi {
    override fun getEvents(onFinishedListener: EventsContract.GetEventsFromApi.OnFinishedListener) {
        val service = RetrofitInstance.getRetrofitInstance()?.create(GetRetrofitService::class.java)

        if(service != null) {
            val call = service.getMatchEvents()

            Log.w("URL Called", call.request().url().toString());


            call.enqueue(object: Callback<List<MatchEvent>> {
                override fun onFailure(call: Call<List<MatchEvent>>, t: Throwable) {
                    onFinishedListener.onFailure(t)
                }

                override fun onResponse(call: Call<List<MatchEvent>>, response: Response<List<MatchEvent>>) {
                    onFinishedListener.onFinished(response.body()!!)
                }
            })

        }
    }
}