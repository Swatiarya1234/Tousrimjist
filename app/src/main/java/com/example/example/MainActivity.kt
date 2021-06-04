 package com.example.example

import android.location.*
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.Manifest;
import androidx.appcompat.app.AppCompatActivity
import com.example.example.Core.Gpstracker
import com.example.example.Core.Permissions
import com.google.android.material.tabs.TabLayout
import java.io.IOException
import java.util.*



 class MainActivity : AppCompatActivity(),View.OnClickListener
 {
     private lateinit var TabLayout:TabLayout
     protected  lateinit var textView:TextView
     protected lateinit var  values:TextView
     protected lateinit var GpsTracker:Permissions
     protected var REQUEST_CODE =1
     lateinit var LocationListener:Gpstracker
     lateinit var latitudestring : String
     lateinit var longitudestring: String

     override fun onCreate(savedInstanceState: Bundle?) {

         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)
         TabLayout = findViewById(R.id.tab_layout)
         textView = findViewById(R.id.latitude)
         values = findViewById(R.id.longitude)
         GpsTracker = Permissions(applicationContext)
         GpsTracker.askpermission(Manifest.permission.ACCESS_FINE_LOCATION, REQUEST_CODE, Manifest.permission.ACCESS_COARSE_LOCATION);
         LocationListener = Gpstracker(applicationContext)

     }
     override fun onClick(v: View?) {
        when(v?.id){

        }
    }

//     override fun onLocationChanged(location: Location) {
//         latitudestring = location.latitude.toString()
//         latitudestring = location.longitude.toString()
//         getSharedPrefrences(location.longitude,location.latitude)
//     }
//
//     private fun getSharedPrefrences(longitudestring: Double, latitudestring: Double) : String{
//         val result = java.lang.StringBuilder()
//         try {
//
//             val geocoder = Geocoder(this, Locale.getDefault())
//             val addresses: List<Address> = geocoder.getFromLocation(longitudestring, latitudestring, 1)
//             if (addresses.size > 0 && addresses != null)  {
//
//                 val address: Address = addresses[0]
//                 result.append(address.getLocality()).append("\n")
//                 result.append(address.getCountryName())
//                 Log.d("append",address.locality.toString())
//                 Log.d("append",address.countryName.toString())
//                 Log.d("append",address.locality.toString())
//
//             }
//         } catch (e: IOException) {
//             Log.e("tag", e.message.toString())
//         }
//         return result.toString()
//     }
//

 }
