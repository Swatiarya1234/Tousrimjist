 package com.example.example

import android.Manifest
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.example.Core.Gpstracker
import com.example.example.Core.Permissions
import com.example.example.Core.Weather.Pojoclasses.RestClasses
import com.example.example.Core.Weather.Pojoclasses.WeatherMain
import com.example.example.Core.Weather.RestClient
import com.google.android.material.tabs.TabLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


 class MainActivity : AppCompatActivity(),View.OnClickListener{
     private lateinit var TabLayout:TabLayout
     protected lateinit var Permission:Permissions
     protected var  REQUEST_CODE = 1
     protected lateinit var String:String
     protected lateinit var locationListener:Gpstracker
     protected  var restClient:RestClient ? = null
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)
         Permission = Permissions(this)
         Permission.askPermission(REQUEST_CODE, Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION);
         locationListener = Gpstracker(getApplicationContext())
         restClient = RestClient
         restClient!!.responseGenerated()
     }

     override fun onClick(v: View?) {
        when(v?.id){

        }
    }


 }
