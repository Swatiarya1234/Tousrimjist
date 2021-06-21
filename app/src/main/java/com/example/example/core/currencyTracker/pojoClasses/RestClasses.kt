package com.example.example.core.currencyTracker.pojoClasses

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RestClasses {

    @GET("convert")
    fun getCurrencyStatus(@Query("q") Usd_php: String?, @Query("compact") appid:String?, @Query("apiKey") apikey: String?): Call<CurrencyTrackerMain?>?
}