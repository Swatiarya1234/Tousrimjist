 package com.example.example

import android.Manifest
import android.R.attr.country
import android.R.attr.description
import android.location.*
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.example.Core.Gpstracker
import com.example.example.Core.Permissions
import com.example.example.Core.Weather.Pojoclasses.RestClasses
import com.example.example.Core.Weather.Pojoclasses.Weather
import com.example.example.Core.Weather.Pojoclasses.WeatherPujomain
import com.example.example.Core.Weather.RestClient
import com.google.android.material.tabs.TabLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


 class MainActivity : AppCompatActivity(),View.OnClickListener{
     private lateinit var TabLayout:TabLayout

//     protected lateinit var textView:TextView
//     protected lateinit var  values:TextView
     protected lateinit var Permission:Permissions
     protected var  REQUEST_CODE = 1
     protected lateinit var String:String
     protected lateinit var locationListener:Gpstracker
     protected lateinit var Api : RestClasses
     protected lateinit var RestClient:RestClient



     override fun onCreate(savedInstanceState: Bundle?) {

         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)
     //    TabLayout = findViewById(R.id.tab_layout)
//         textView = findViewById(R.id.latitude)
//         values = findViewById(R.id.longitude)
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
         val lon = -74.40816
         val maxreturns = 3
         val getReponse = RestClient.

     }

 }
