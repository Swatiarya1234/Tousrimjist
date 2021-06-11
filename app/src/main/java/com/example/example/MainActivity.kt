 package com.example.example

import android.Manifest
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.example.Core.GpsTracker
import com.example.example.Core.Permissions
import com.example.example.ViewModel.MainActivityViewModel
import com.example.example.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout


 class MainActivity : AppCompatActivity(),View.OnClickListener{
     protected lateinit var Permission:Permissions
     protected var  REQUEST_CODE = 1
     protected lateinit var String:String
     protected var  binding: ActivityMainBinding? = null
     protected lateinit var locationListener:GpsTracker
     protected lateinit var MainActivityViewModel:MainActivityViewModel
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
      //   setContentView(R.layout.activity_main)
         binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
         Permission = Permissions(this)
         Permission.askPermission(REQUEST_CODE, Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION);
         locationListener = GpsTracker(getApplicationContext())
         MainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
         binding!!.viewModel.getUsers()

     }

     override fun onClick(v: View?) {
        when(v?.id){

        }
    }


 }
