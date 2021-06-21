package com.example.example.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.example.core.Constants
import com.example.example.core.currencyTracker.pojoClasses.CurrencyTrackerMain

import com.example.example.core.currencyTracker.pojoClasses.RestClasses
import com.example.example.core.currencyTracker.RestClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CurrencyTrackerViewModel :ViewModel() {

    private var currencyTrackerMain: MutableLiveData<CurrencyTrackerMain>? = null
    private var currencyTracker: MutableLiveData<String> ? = null
    private lateinit var api :RestClasses


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
        api.getCurrencyStatus(Constants.USD_PHP,Constants.COMPACT,Constants.CURRENCY_TRACKER_API_KEY)!!.enqueue(object :
            Callback<CurrencyTrackerMain?> {
            override fun onResponse(call: Call<CurrencyTrackerMain?>, response: Response<CurrencyTrackerMain?>) {
                if (response.body() != null) {

                }
            }
            override fun onFailure(call: Call<CurrencyTrackerMain?>, t: Throwable) {}
        })
    }

}