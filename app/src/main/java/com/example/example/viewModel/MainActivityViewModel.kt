package com.example.example.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.example.Core.Constants
import com.example.example.Core.Weather.PojoClasses.RestClasses
import com.example.example.Core.Weather.PojoClasses.WeatherMain
import com.example.example.Core.Weather.RestClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivityViewModel: ViewModel() {
    private var users: MutableLiveData<WeatherMain>? = null
    private var latitudeString : MutableLiveData<String> ? = null
    private var longitudeString : MutableLiveData<String> ? = null
    private lateinit var api : RestClasses
    fun getUsers(): LiveData<WeatherMain?>? {
        if (users == null) {
            users = MutableLiveData<WeatherMain>()
            //getWeatherData(0.00000,0.223333)
        }
        return users
    }

    fun getWeatherData() {
        val latt = 40.7539
        val lon = -74.9090
        api = RestClient.getClient()!!.create(RestClasses::class.java)
        api.getWeatherStatus(latt,lon, Constants.WEATHERURL)!!.enqueue(object :
            Callback<WeatherMain?> {
            override fun onResponse(call: Call<WeatherMain?>, response: Response<WeatherMain?>) {
                if (response.body() != null) {
                    latitudeString!!.setValue(if (users == null) null else users!!.value!!.city.country)
                    longitudeString!!.setValue(if (users == null) null else users!!.value!!.city.name)
                }
            }
            override fun onFailure(call: Call<WeatherMain?>, t: Throwable) {}
        })
    }
}