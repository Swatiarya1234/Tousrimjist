package com.example.example.Core.Weather.Pojoclasses

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RestClasses {
    @GET("forecast")
    fun getTasks(@Query("latitude") latitide: Double?, @Query("longitude")longitude:Double?,@Query("appid") appid: String?): Call<WeatherPujomain?>?

    companion object {
        const val Url = "http://api.openweathermap.org/data/2.5/"
    }
}