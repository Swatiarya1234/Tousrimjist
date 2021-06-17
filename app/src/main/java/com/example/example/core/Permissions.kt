package com.example.example.core

import android.app.Activity
import android.content.pm.PackageManager
import android.location.LocationManager
import android.widget.Toast
import androidx.core.app.ActivityCompat


class Permissions(val context: Activity) : ActivityCompat(),ActivityCompat.OnRequestPermissionsResultCallback {

    val LOCATION_REQUEST_CODE = 1
    private lateinit var locationManager: LocationManager
    private val locationPermissionCode = 2

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            LOCATION_REQUEST_CODE -> if (grantResults.size > 0 && grantResults[0] === PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(context, " Location Permission granted", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(context, " Location Permission denied", Toast.LENGTH_LONG).show()
            }
        }
    }
    fun askPermission(requestcode: Int, primaryPermission:String,secondaryPermission:String) {
        if (checkSelfPermission(
                context,
                primaryPermission
            ) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(
                context,
                secondaryPermission
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions((context as Activity), arrayOf(primaryPermission,secondaryPermission), requestcode)
        } else {
            Toast.makeText(context, "Permission already granted", Toast.LENGTH_LONG).show()
        }
    }

//    fun GpsPermisions(){
//        locationManager = context.getSystemService(LOCATION_SERVICE) as LocationManager
//        /* enable the gps permissions */
//       if ((ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
//             ActivityCompat.requestPermissions(context, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), locationPermissionCode)
//        }
//        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), locationPermissionCode)
//    }
}


