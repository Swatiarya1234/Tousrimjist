package com.example.example.core.gpsTracker

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.*
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.example.core.Constants
import java.io.IOException
import java.util.*

class GpsTracker(val context:Context, workerParams: WorkerParameters) : LocationListener, CoroutineWorker(context, workerParams){
    private lateinit var mainContext:Context
    init{
        mainContext = context
    }

    fun requestLocationUpdate(){
      val  locationManager = mainContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if ((ContextCompat.checkSelfPermission(mainContext, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
            ActivityCompat.requestPermissions(mainContext as Activity, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                Constants.LOCATION_PERMISSION_CODE
            )
        }
         locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5f, this)
         Log.d("request location update","request location upadted")
    }

    override fun onLocationChanged(location: Location) {
        getLocationfused(location.getLatitude(),location.getLongitude())
  }
    private fun getLocationfused(latitude: Double, longitude: Double): String {
        val result = java.lang.StringBuilder()
        try {
            val geocoder = Geocoder(context, Locale.getDefault())
            val addresses: List<Address> = geocoder.getFromLocation(latitude, longitude, 1)
            if (addresses.size > 0 && addresses != null)  {
                val address: Address = addresses[0]
                result.append(address.locality).append("\n")
                result.append(address.longitude).append("\n")
               // result.append(address.getAddressLine().append("\n"))
                Log.d("locality",address.locality.toString())
                Log.d("country",address.countryName.toString())

            }
        }
        catch (e: IOException) {
            Log.e("tag", e.message.toString())
        }
        return result.toString()

    }

    override suspend fun doWork(): Result {
        return try {
            try {
                Log.d("MyWorker", "Run work manager")
                //Do Your task here
                requestLocationUpdate()
                Result.success()
            } catch (e: Exception) {
                Log.d("MyWorker", "exception in doWork ${e.message}")
                Result.failure()
            }
        } catch (e: Exception) {
            Log.d("MyWorker", "exception in doWork ${e.message}")
            Result.failure()
        }
    }

}