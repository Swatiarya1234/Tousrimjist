 package com.example.example

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.example.R
import com.example.example.core.currencyTracker.CurrencyTracker
import com.example.example.clickInterfaces.MainActivityClickListener
import com.example.example.core.Constants
import com.example.example.core.gpsTracker.GpsTracker
import com.example.example.core.gpsTracker.GpsTrackerWorkManager
import com.example.example.core.gpsTracker.GpsTrackerWorker
import com.example.example.databinding.ActivityMainBinding


 class MainActivity : AppCompatActivity(),View.OnClickListener,MainActivityClickListener{

     protected lateinit var String:String
     //this is a static method which can be called directly
     companion object{
         var context:Context ? = null
     }

     @RequiresApi(Build.VERSION_CODES.M)
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
          setContentView(R.layout.activity_main)
            context = this
       //   binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
            getPermissions()
            GpsTrackerWorkManager.refreshPeriodicWork(this)


     //          MainActivityViewmodel = ViewModelProvider(this,CurrencyTrackermodelFactory).get(MainActivityViewmodel!!::class.java)
//          binding!!.viewModel = MainActivityViewmodel
     }

     private fun getPermissions() {
         if ((ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
             ActivityCompat.requestPermissions(
                 this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION,android.Manifest.permission.ACCESS_COARSE_LOCATION),
                 Constants.LOCATION_PERMISSION_CODE
             )
         }
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
