package com.example.example.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.example.Core.Constants
import com.example.example.Core.CurrencyTracker.PojoClasses.CurrencyTrackerMain
import com.example.example.Core.Weather.PojoClasses.RestClasses
import com.example.example.Core.Weather.PojoClasses.WeatherMain
import com.example.example.Core.Weather.RestClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class currencyTrackerViewModel :ViewModel() {
    private var currencyTrackerMain: MutableLiveData<CurrencyTrackerMain>? = null
    private var currencyTracker: MutableLiveData<String> ? = null
    private lateinit var api : RestClasses
    fun getUsers(): LiveData<CurrencyTrackerMain?>? {
        if (currencyTrackerMain == null) {
            currencyTrackerMain = MutableLiveData<CurrencyTrackerMain>()
            //getWeatherData(0.00000,0.223333)
        }
        return currencyTrackerMain
    }
    fun getlatitude() {
        val latt = 40.7539
        val lon = -74.9090
        api = RestClient.getClient()!!.create(RestClasses::class.java)
        api.getWeatherStatus(latt,lon, Constants.WEATHERURL)!!.enqueue(object :
            Callback<WeatherMain?> {
            override fun onResponse(call: Call<WeatherMain?>, response: Response<WeatherMain?>) {
                if (response.body() != null) {
                     currencyTracker!!.setValue((currencyTrackerMain == null) null else currencyTrackerMain!!.value!!.city.country)
                }
            }
            override fun onFailure(call: Call<WeatherMain?>, t: Throwable) {}
        })
    }

}