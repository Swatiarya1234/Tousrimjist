package com.example.example.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.example.Core.Constants
import com.example.example.Core.CurrencyTracker.PojoClasses.CurrencyTrackerMain
import com.example.example.Core.CurrencyTracker.CurrencyTracker

import com.example.example.Core.CurrencyTracker.PojoClasses.RestClasses
import com.example.example.Core.CurrencyTracker.RestClient
import com.example.example.Core.Weather.PojoClasses.WeatherMain
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class currencyTrackerViewModel :ViewModel() {
    private var currencyTrackerMain: MutableLiveData<CurrencyTrackerMain>? = null
    private var currencyTracker: MutableLiveData<String> ? = null
    private lateinit var api :RestClasses
    private val USD_PHP:String = "USD_PHP"
    private val compact:String = "ultra"

    fun getUsers(): LiveData<CurrencyTrackerMain?>? {
        if (currencyTrackerMain == null) {
            currencyTrackerMain = MutableLiveData<CurrencyTrackerMain>()
            //getWeatherData(0.00000,0.223333)
        }
        return currencyTrackerMain
    }
    // rest please do have this please
    fun getlatitude() {
        api = RestClient.getRest()!!.create(RestClasses::class.java)
        api.getCurrencyStatus(USD_PHP,compact,Constants.CURRENCYTRACKERAPIKEY)!!.enqueue(object :
            Callback<CurrencyTrackerMain?> {
            override fun onResponse(call: Call<CurrencyTrackerMain?>, response: Response<CurrencyTrackerMain?>) {
                if (response.body() != null) {

                }
            }
            override fun onFailure(call: Call<CurrencyTrackerMain?>, t: Throwable) {}
        })
    }

}