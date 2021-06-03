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
import com.example.example.Core.Permissions
import com.google.android.material.tabs.TabLayout
import java.io.IOException
import java.security.Permission
import java.util.*



 class MainActivity : AppCompatActivity(),View.OnClickListener ,LocationListener{

     private lateinit var TabLayout:TabLayout
     private lateinit var locationManager: LocationManager
     private val locationPermissionCode = 2
     protected  lateinit var textView:TextView
     protected lateinit var  values:TextView
     protected lateinit var GpsTracker:Permissions
     protected var REQUEST_CODE =1

     override fun onCreate(savedInstanceState: Bundle?) {

         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)
         TabLayout = findViewById(R.id.tab_layout)
         textView = findViewById(R.id.latitude)
         values = findViewById(R.id.longitude)
   //      enableGpsAccess()
         GpsTracker = Permissions(applicationContext)
         GpsTracker.askpermission(Manifest.permission.ACCESS_FINE_LOCATION, REQUEST_CODE, Manifest.permission.ACCESS_COARSE_LOCATION);


     }

     override fun onClick(v: View?) {
        when(v?.id){

        }
    }
//     private fun enableGpsAccess() {
//
//         locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
//         /* enable the gps permissions */
//         if ((ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
//             ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), locationPermissionCode)
//         }
//         locationManager!!.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5f, this)
//
//     }
     override fun onLocationChanged(location: Location) {
//        textView.text = location.latitude.toString()
//        values.text = location.longitude.toString()
         Log.d("textValue",location.longitude.toString())
         Log.d("values",location.longitude.toString())
         getLocationfused(location.latitude,location.longitude)

     }
    private fun getLocationfused(latitude: Double, longitude: Double): String {

         val result = java.lang.StringBuilder()
         try {
             val geocoder = Geocoder(this, Locale.getDefault())
             val addresses: List<Address> = geocoder.getFromLocation(latitude, longitude, 1)
             if (addresses.size > 0 && addresses != null)  {
                 val address: Address = addresses[0]
                 result.append(address.getLocality()).append("\n")
                 result.append(address.getCountryName())
                 Log.d("append",address.locality.toString())
                 Log.d("append",address.countryName.toString())
                 textView.text = address.locality.toString()
                 values.text = address.countryName.toString()

             }
         } catch (e: IOException) {
             Log.e("tag", e.message.toString())
         }
         return result.toString()

     }


 }
