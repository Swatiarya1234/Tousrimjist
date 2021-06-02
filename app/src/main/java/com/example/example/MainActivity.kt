 package com.example.example

import android.content.ContentValues.TAG
import android.content.Context
import android.content.pm.PackageManager
import android.location.*
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.example.example.AdapterClasses.AdapterClasses
import com.example.example.Subclasses.GpsTracker
import com.google.android.material.tabs.TabLayout
import java.io.IOException
import java.util.*


 class MainActivity : AppCompatActivity(),View.OnClickListener,LocationListener{

     private lateinit var TabLayout:TabLayout
     private lateinit var locationManager: LocationManager
     private val locationPermissionCode = 2
     var latitude:Double = 0.0
     var longitude :Double = 0.0
     var result = StringBuilder()
     protected  lateinit var textView:TextView
     protected lateinit var  values:TextView
     protected lateinit var address2: String
     override fun onCreate(savedInstanceState: Bundle?) {

         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)
         TabLayout = findViewById(R.id.tab_layout)
         textView = findViewById(R.id.latitude)
         values = findViewById(R.id.longitude)
         function()

     }

     private fun function() {
         locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
         if ((ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
             ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), locationPermissionCode)
         }
         locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5f, this)

     }


     override fun onClick(v: View?) {
        when(v?.id){

        }
    }
    /*
     latitide and latitide
     */
     override fun onLocationChanged(location: Location) {

       textView.text = location.latitude.toString()
       values.text = location.longitude.toString()
         Log.d("textValue",location.longitude.toString())
         Log.d("values",location.longitude.toString())
         getLocationfused(location.longitude,location.longitude)

     }

     private fun getLocationfused(latitude: Double, longitude: Double): String {
         val result = java.lang.StringBuilder()
         try {
             val geocoder = Geocoder(this, Locale.getDefault())
             val addresses: List<Address> = geocoder.getFromLocation(latitude, longitude, 1)
             if (addresses.size > 0 && addresses != null)  {
                 val address: Address = addresses[0]
                 address2 = address.countryName
                 result.append(address.getLocality()).append("\n")
                 result.append(address.getCountryName())
                 Log.d("append",address.locality.toString())
                 Log.d("append",address.countryName.toString())

             }
         } catch (e: IOException) {
             Log.e("tag", e.message.toString())
         }

         return result.toString()

     }

     override fun onRequestPermissionsResult(
         requestCode: Int,
         permissions: Array<out String>,
         grantResults: IntArray
     ) {
         super.onRequestPermissionsResult(requestCode, permissions, grantResults)
         if (requestCode == locationPermissionCode) {
             if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                 Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
             }
             else {
                 Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
             }
         }
     }

 }
