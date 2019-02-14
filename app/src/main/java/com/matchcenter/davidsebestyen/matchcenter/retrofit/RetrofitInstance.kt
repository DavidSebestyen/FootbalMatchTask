package com.matchcenter.davidsebestyen.matchcenter.retrofit

import okhttp3.MediaType
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit



class RetrofitInstance {

    companion object {


        private var retrofit: Retrofit? = null
        private val BASE_URL = "https://feeds.tribehive.co.uk/DigitalStadiumServer/"

        /**
         * Create an instance of Retrofit object
         */
        fun getRetrofitInstance(): Retrofit? {

            val contentType = MediaType.parse("application/json")

            if (retrofit == null) {
                retrofit = retrofit2.Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return retrofit
        }
    }
}