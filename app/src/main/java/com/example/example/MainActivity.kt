 package com.example.example

import android.location.*
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.Manifest;
import androidx.appcompat.app.AppCompatActivity
import com.example.example.Core.Gpstracker
import com.example.example.Core.Permissions
import com.google.android.material.tabs.TabLayout
import java.util.*



 class MainActivity : AppCompatActivity(),View.OnClickListener
 {
     private lateinit var TabLayout:TabLayout
     protected  lateinit var textView:TextView
     protected lateinit var  values:TextView
     protected lateinit var Permission:Permissions
     protected lateinit var locationListener:Gpstracker


     override fun onCreate(savedInstanceState: Bundle?) {

         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)
         TabLayout = findViewById(R.id.tab_layout)
         textView = findViewById(R.id.latitude)
         values = findViewById(R.id.longitude)
         Permission = Permissions(applicationContext)
         Permission.askPermission(REQUEST_CODE, Manifest.permission.ACCESS_COARSE_LOCATION);
         locationListener = Gpstracker(applicationContext)

     }
     override fun onClick(v: View?) {
        when(v?.id){

        }
    }
 }
