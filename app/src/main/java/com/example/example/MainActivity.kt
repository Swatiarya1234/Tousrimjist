 package com.example.example

import android.Manifest
import android.content.Intent
import android.location.LocationManager
import android.os.Bundle
import android.telephony.CarrierConfigManager
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.example.core.currencyTracker.CurrencyTracker
import com.example.example.core.GpsTracker
import com.example.example.core.Permissions
import com.example.example.clickInterfaces.MainActivityClickListener
import com.example.example.core.factoryMethods.CurrencyTrackermodelFactory
import com.example.example.core.factoryMethods.MainActivityviewmodelFactory
import com.example.example.viewModel.MainActivityViewmodel
import com.example.example.databinding.ActivityMainBinding


 class MainActivity : AppCompatActivity(),View.OnClickListener,MainActivityClickListener{

     protected lateinit var Permission:Permissions
     protected var  REQUEST_CODE = 1
     protected lateinit var String:String
     protected var  binding: ActivityMainBinding? = null
     protected lateinit var locationListener:GpsTracker
     protected lateinit var CurrencyTrackermodelFactory : MainActivityviewmodelFactory
     protected  lateinit var MainActivityViewmodel : MainActivityViewmodel

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
       //   setContentView(R.layout.activity_main)
          binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
          Permission = Permissions(this)
          Permission.askPermission(REQUEST_CODE, Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION);
          locationListener = GpsTracker(getApplicationContext())
          MainActivityViewmodel = ViewModelProvider(this,CurrencyTrackermodelFactory).get(MainActivityViewmodel!!::class.java)
          binding!!.viewModel = MainActivityViewmodel

     }

     override fun onClick(v: View?) {
        when(v?.id){

        }
    }

     override fun onClickListener(view: View){
         val intent: Intent = Intent(this,CurrencyTracker::class.java)
         startActivity(intent)
     }


 }
