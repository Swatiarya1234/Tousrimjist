 package com.example.example

import android.Manifest
import android.location.*
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.example.Core.Gpstracker
import com.example.example.Core.Permissions
import com.example.example.Core.Weather.Pojoclasses.RestClasses
import com.example.example.Core.Weather.Pojoclasses.WeatherPujomain
import com.example.example.Core.Weather.RestClient
import com.google.android.material.tabs.TabLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


 class MainActivity : AppCompatActivity(),View.OnClickListener{
     private lateinit var TabLayout:TabLayout
     private lateinit var latitude:String
     protected lateinit var Permission:Permissions
     protected var  REQUEST_CODE = 1
     protected lateinit var String:String
     protected lateinit var locationListener:Gpstracker
     protected lateinit var api : RestClasses
     private lateinit var restClient:RestClient
     private lateinit var restClasses: RestClasses
     private val API:String = "9ddde7bb16caabbd0f16d18d619f1bee"
     override fun onCreate(savedInstanceState: Bundle?) {

         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)
         Permission = Permissions(this)
         Permission.askPermission(REQUEST_CODE, Manifest.permission.ACCESS_COARSE_LOCATION);
         locationListener = Gpstracker(getApplicationContext())
         reposnegenerated()

     }
     override fun onClick(v: View?) {
        when(v?.id){

        }
    }
     fun reposnegenerated() {
         val latt = 40.7539
         val lon = -74.9090
       //  restClasses = RestClient.buildService(RestClasses::class.java)
        // restClient = restClasses.getTasks(latt,lon,API)
         api = RestClient.getClient()!!.create(RestClasses::class.java)
         api.getTasks(latt,lon,API)!!.enqueue(object : Callback<WeatherPujomain?> {
             override fun onResponse(call: Call<WeatherPujomain?>, response: Response<WeatherPujomain?>) {
                 if (response.body() != null) {
                    latitude  = response.body().toString()
                     Log.d("response",latitude)
                 }
             }
             override fun onFailure(call: Call<WeatherPujomain?>, t: Throwable) {}
         })
     }

 }
