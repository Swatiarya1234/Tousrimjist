package com.example.example.Core.CurrencyTracker.PujoClasses

import com.example.example.Core.Weather.Pojoclasses.WeatherMain
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyRestClasses {
    @GET("convert")
    fun getWeatherStatus(@Query("q") currency: String?, @Query("compact") appid:String?, @Query("apiKey") apikey: String?): Call<WeatherMain?>?

}