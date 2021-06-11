package com.example.example.Core.Weather.Pojoclasses

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RestClasses {
    @GET("forecast")
    fun getWeatherStatus(@Query("lat") latitude: Double?, @Query("lon")longitude:Double?,@Query("appid") appid: String?): Call<WeatherMain?>?
}