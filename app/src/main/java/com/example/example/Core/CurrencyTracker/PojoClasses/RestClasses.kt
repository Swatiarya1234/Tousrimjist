package com.example.example.Core.CurrencyTracker.PojoClasses

import com.example.example.Core.Weather.PojoClasses.WeatherMain
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RestClasses {

    @GET("convert")
    fun getCurrencyStatus(@Query("q") Usd_php: String?, @Query("compact") appid:String?, @Query("apiKey") apikey: String?): Call<CurrencyTrackerMain?>?

}