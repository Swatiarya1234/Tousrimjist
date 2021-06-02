package com.example.example.Subclasses

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.IBinder
import android.provider.Settings
import android.util.Log
import androidx.core.app.ActivityCompat


class GpsTracker: LocationListener,Service{
    constructor(applicationContext: Context?)

    var mContext: Context? = null
    var isGPSEnabled = false
    var canGetLocation = false
    var location // location
            : Location? = null
    var latitude // latitude
            = 0.0
    var longitude // longitude
            = 0.0
    private val MIN_DISTANCE_CHANGE_FOR_UPDATES: Long = 1
    private val MIN_TIME_BW_UPDATES: Long = 1 // 1 minute


    // Declaring a Location Manager
    protected var locationManager: LocationManager? = null
    var isNetworkEnabled = false


    @JvmName("getLocation1")
    fun getLocation():Location? {
       try {
           locationManager = mContext!!.getSystemService(LOCATION_SERVICE) as LocationManager?
           isGPSEnabled = locationManager!!.isProviderEnabled(LocationManager.GPS_PROVIDER)
           isNetworkEnabled = locationManager!!.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
           if (!isGPSEnabled && !isNetworkEnabled) {
               // no network provider is enabled
           }
           else{
               this.canGetLocation = true
               if (ActivityCompat.checkSelfPermission(
                       mContext!!,
                       Manifest.permission.ACCESS_FINE_LOCATION
                   ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                       mContext!!, Manifest.permission.ACCESS_COARSE_LOCATION
                   ) != PackageManager.PERMISSION_GRANTED
               ) {
                   ActivityCompat.requestPermissions(
                       (mContext as Activity?)!!,
                       arrayOf(
                           Manifest.permission.ACCESS_FINE_LOCATION,
                           Manifest.permission.ACCESS_COARSE_LOCATION
                       ),
                       101
                   )
               }
           }
           if (isGPSEnabled) {
               if (location == null) {
                   //check the network permission
                   if (ActivityCompat.checkSelfPermission(
                           mContext!!,
                           Manifest.permission.ACCESS_FINE_LOCATION
                       ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                           mContext!!, Manifest.permission.ACCESS_COARSE_LOCATION
                       ) != PackageManager.PERMISSION_GRANTED
                   ) {
                       ActivityCompat.requestPermissions(
                           (mContext as Activity?)!!,
                           arrayOf(
                               Manifest.permission.ACCESS_FINE_LOCATION,
                               Manifest.permission.ACCESS_COARSE_LOCATION
                           ),
                           101
                       )
                   }
                   locationManager!!.requestLocationUpdates(
                       LocationManager.GPS_PROVIDER,
                       MIN_TIME_BW_UPDATES,
                       MIN_DISTANCE_CHANGE_FOR_UPDATES.toFloat(), this
                   )
                   Log.d("GPS Enabled", "GPS Enabled")
                   if (locationManager != null) {
                       location = locationManager!!
                           .getLastKnownLocation(LocationManager.GPS_PROVIDER)
                       if (location != null) {
                           latitude = location!!.latitude
                           longitude = location!!.longitude
                       }
                   }
               }
           }


       }catch (e:Exception) {
           e.printStackTrace();
       }
        return location

    }
    fun stopUsingGps(){
        if(locationManager != null){
            locationManager!!.removeUpdates(this);
        }
    }

    fun latitide():Double{
        if(location != null){
            latitude = location!!.getLatitude();
        }

        // return latitude
        return latitude;
    }

    fun cangetLocation():Location{
        return this.cangetLocation()
    }
    fun showSettingsAlert(){
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(mContext)
        alertDialog.setTitle("GPS is settings")
        alertDialog.setMessage("GPS is not enabled. Do you want to go to settings menu?")

        // On pressing Settings button

        // On pressing Settings button
        alertDialog.setPositiveButton(
            "Settings"
        ) { dialog, which ->
            val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
            mContext!!.startActivity(intent)
        }
        alertDialog.setNegativeButton(
            "Cancel"
        ) { dialog, which -> dialog.cancel() }
        alertDialog.show()

    }

    override fun onLocationChanged(location: Location) {
        TODO("Not yet implemented")
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


}