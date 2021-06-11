package com.example.example.Core

import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.util.Log
import com.example.example.databinding.MainActivityBinding
import java.io.IOException
import java.util.*

class GpsTracker(val context:Context) : LocationListener {
    private lateinit var Location:String
    private lateinit var Latitude:String
    private lateinit var MainActivityBinding:MainActivityBinding

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

}