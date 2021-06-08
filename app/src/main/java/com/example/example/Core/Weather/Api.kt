package com.example.example.Core.Weather

import retrofit2.http.GET
import com.example.example.Core.Weather.Pojoclasses.`object`
import retrofit2.Call
import retrofit2.http.Query

interface Api {
    @GET("forecast")
    fun getTasks(@Query("q") city: String?, @Query("appid") appid: String?): Call<`object`?>?

    companion object {
        const val Url = "http://api.openweathermap.org/data/2.5/"
    }
}