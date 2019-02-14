package com.matchcenter.davidsebestyen.matchcenter.main

import android.util.Log
import com.matchcenter.davidsebestyen.matchcenter.data.Match
import com.matchcenter.davidsebestyen.matchcenter.retrofit.GetRetrofitService
import com.matchcenter.davidsebestyen.matchcenter.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetMatchFromApiImpl: MainContract.GetMatchFromApi {
    override fun getMatch(onFinishedListener: MainContract.GetMatchFromApi.OnFinishedListener) {
        val service = RetrofitInstance.getRetrofitInstance()?.create(GetRetrofitService::class.java)

        if(service != null) {
            val call = service.getMatch()

            Log.w("URL Called", call.request().url().toString());


            call.enqueue(object : Callback<Match>{
                override fun onFailure(call: Call<Match>, t: Throwable) {
                    onFinishedListener.onFailure(t)
                }

                override fun onResponse(call: Call<Match>, response: Response<Match>) {
                    onFinishedListener.onFinished(response.body()!!)
                }

            })
        }
    }

}
