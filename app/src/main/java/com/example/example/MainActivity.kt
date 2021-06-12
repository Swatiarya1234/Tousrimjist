 package com.example.example

import android.Manifest
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.example.Core.GpsTracker
import com.example.example.Core.Permissions
import com.example.example.Core.factoryMethods.mainActivityviewmodelFactory
import com.example.example.viewModel.MainActivityViewModel
import com.example.example.databinding.ActivityMainBinding


 class MainActivity : AppCompatActivity(),View.OnClickListener{
     protected lateinit var Permission:Permissions
     protected var  REQUEST_CODE = 1
     protected lateinit var String:String
     protected var  binding: ActivityMainBinding? = null
     protected lateinit var locationListener:GpsTracker
     protected var MainActivityViewModel:MainActivityViewModel ? = null
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
      //   setContentView(R.layout.activity_main)
         binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
         Permission = Permissions(this)
         Permission.askPermission(REQUEST_CODE, Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION);
         locationListener = GpsTracker(getApplicationContext())
         val factory = mainActivityviewmodelFactory()
         MainActivityViewModel = ViewModelProviders.of(this,factory).get(MainActivityViewModel!!::class.java)
         binding!!.viewModel = MainActivityViewModel
     }

     override fun onClick(v: View?) {
        when(v?.id){

        }
    }


 }
