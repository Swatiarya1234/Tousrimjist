package com.example.example.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.example.core.Constants
import com.example.example.core.weather.pojoClasses.RestClasses
import com.example.example.core.weather.pojoClasses.WeatherMain
import com.example.example.core.weather.RestClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivityViewmodel: ViewModel() {
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

}