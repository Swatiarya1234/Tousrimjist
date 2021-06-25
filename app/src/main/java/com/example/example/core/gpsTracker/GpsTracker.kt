package com.example.example.core.gpsTracker

import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.util.Log
import com.example.example.MainActivity
import com.example.example.core.weather.pojoClasses.Main
import java.io.IOException
import java.util.*

class GpsTracker private constructor():LocationListener {

    companion object {
        private var instance: GpsTracker? = null
        fun getInstance(): GpsTracker? {
            if (instance == null) {
                instance = GpsTracker()
            }
            return instance
        }
    }

    override fun onLocationChanged(location: Location) {
        getLocationfused(location.getLatitude(),location.getLongitude())
        Log.d("latitude",location.latitude.toString())
        Log.d("longitude",location.longitude.toString())

    }

    private fun getLocationfused(latitude: Double, longitude: Double): String {
        val result = java.lang.StringBuilder()
        try {
            // Now I am using a companion variable
                val geocoder = Geocoder(MainActivity.context, Locale.getDefault())
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
}