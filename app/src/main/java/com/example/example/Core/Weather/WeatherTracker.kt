package com.example.example.Core.Weather
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class WeatherTracker {

    private val API:String = "9ddde7bb16caabbd0f16d18d619f1bee"
    val Retrofit:Retrofit? =null
    var Data: WeatherTracker? = null
    lateinit var Api: Api


    fun getInstance(): WeatherTracker? {
        if (Data == null) {
            Data = WeatherTracker()
        }
        return Data
    }
    init{
        val retrofit: Retrofit = retrofit2.Retrofit.Builder()
            .baseUrl(com.example.example.Core.Weather.Api.Url)
            .addConverterFactory(GsonConverterFactory.create())
           // .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
       Api  = retrofit.create(Api::class.java)
    }

}