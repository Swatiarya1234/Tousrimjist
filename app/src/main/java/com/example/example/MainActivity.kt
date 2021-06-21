 package com.example.example

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.work.WorkerParameters
import com.example.example.core.currencyTracker.CurrencyTracker
import com.example.example.core.gpsTracker.GpsTracker
import com.example.example.clickInterfaces.MainActivityClickListener
import com.example.example.core.factoryMethods.MainActivityviewmodelFactory
import com.example.example.core.gpsTracker.GpsTrackerWorkManager
import com.example.example.viewModel.MainActivityViewmodel
import com.example.example.databinding.ActivityMainBinding


 class MainActivity : AppCompatActivity(),View.OnClickListener,MainActivityClickListener{

     protected var  REQUEST_CODE = 1
     protected lateinit var String:String
     protected var  binding: ActivityMainBinding? = null
     protected lateinit var CurrencyTrackermodelFactory : MainActivityviewmodelFactory
     protected  lateinit var MainActivityViewmodel : MainActivityViewmodel

     @RequiresApi(Build.VERSION_CODES.M)
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
          setContentView(R.layout.activity_main)
       //   binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
            GpsTrackerWorkManager.refreshPeriodicWork(applicationContext)
//          MainActivityViewmodel = ViewModelProvider(this,CurrencyTrackermodelFactory).get(MainActivityViewmodel!!::class.java)
//          binding!!.viewModel = MainActivityViewmodel

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
