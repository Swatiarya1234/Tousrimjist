package com.example.example.core.gpsTracker

import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.util.Log
import com.example.example.MainActivity
import com.example.example.core.gpsTracker.delegate.GpsDelegate
import com.example.example.core.gpsTracker.delegate.GpsProperties
import com.example.example.core.weather.pojoClasses.Main
import java.io.IOException
import java.util.*

class GpsTracker private constructor():LocationListener {


    companion object {
        private var instance: GpsTracker? = null
        lateinit var gpsDelegate:GpsDelegate
        fun getInstance(): GpsTracker? {
            if (instance == null) {
                gpsDelegate = GpsDelegate()
                instance = GpsTracker()

            }
            return instance
        }
    }

    override fun onLocationChanged(location: Location) {
        getLocationfused(location.getLatitude(),location.getLongitude())
    }

    private fun getLocationfused(latitude: Double, longitude: Double): String {
        val result = java.lang.StringBuilder()
        try {
              val geocoder = Geocoder(MainActivity.context, Locale.getDefault())
              val addresses: List<Address> = geocoder.getFromLocation(latitude, longitude, 1)
              if (addresses.size > 0 && addresses != null)  {
                  val address: Address = addresses[0]
                  result.append(address.locality).append("\n")
                  result.append(address.longitude).append("\n")
                 // result.append(address.getAddressLine().append("\n"))
                  var countryName   = address.locality.toString()
                  var country = address.countryName.toString()
            }
        }
        catch (e: IOException) {
            Log.e("tag", e.message.toString())
        }
        return result.toString()
    }
}