package com.example.example.Core.Weather.Pojoclasses

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RestClasses {
    @GET("forecast")
    fun getTasks(@Query("lat") latitide: Double?, @Query("lon")longitude:Double?,@Query("appid") appid: String?): Call<WeatherPujomain?>?

    companion object {
        const val Url = "http://api.openweathermap.org/data/2.5/"
    }
}