 package com.example.example

import android.Manifest
import android.location.LocationManager
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.example.Core.GpsTracker
import com.example.example.Core.Permissions
import com.example.example.Core.factoryMethods.mainActivityviewmodelFactory
import com.example.example.OnClickInterfaces.MainActivityClicklistner
import com.example.example.viewModel.mainActivityViewmodel
import com.example.example.databinding.ActivityMainBinding


 class MainActivity : AppCompatActivity(),View.OnClickListener,MainActivityClicklistner{

     protected lateinit var Permission:Permissions
     protected var  REQUEST_CODE = 1
     protected lateinit var String:String
     protected var  binding: ActivityMainBinding? = null
     protected lateinit var locationListener:GpsTracker
     protected lateinit var locationManager: LocationManager
     protected var MainActivityViewModel:mainActivityViewmodel ? = null
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

     override fun onClickListner(view: View) {

         Toast.makeText(this,"Make test",Toast.LENGTH_SHORT).show();
     }


 }
