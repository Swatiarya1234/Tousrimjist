 package com.example.example

import android.content.pm.PackageManager
import android.location.*
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.Manifest;
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.example.Core.LocationListner
import com.example.example.Core.Permissions
import com.google.android.material.tabs.TabLayout
import java.io.IOException
import java.security.Permission
import java.util.*



 class MainActivity : AppCompatActivity(),View.OnClickListener{

     private lateinit var TabLayout:TabLayout
     protected  lateinit var textView:TextView
     protected lateinit var  values:TextView
     protected lateinit var GpsTracker:Permissions
     protected var REQUEST_CODE =1
     lateinit var LocationListener:LocationListner

     override fun onCreate(savedInstanceState: Bundle?) {

         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)
         TabLayout = findViewById(R.id.tab_layout)
         textView = findViewById(R.id.latitude)
         values = findViewById(R.id.longitude)
         GpsTracker = Permissions(applicationContext)
         GpsTracker.askpermission(Manifest.permission.ACCESS_FINE_LOCATION, REQUEST_CODE, Manifest.permission.ACCESS_COARSE_LOCATION);
         LocationListener = LocationListner(applicationContext)

     }

     override fun onClick(v: View?) {
        when(v?.id){

        }
    }

 }
