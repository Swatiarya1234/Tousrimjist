package com.example.example.Core

import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.util.Log
import java.io.IOException
import java.util.*

class LocationListner(val context:Context) : LocationListener {
    lateinit var Location:String
    lateinit var Latitude:String

    override fun onLocationChanged(location: Location) {
       Location = location.longitude.toString()
       Latitude = location.latitude.toString()
        getLocationfused(location.latitude,location.longitude)
    }
    private fun getLocationfused(latitude: Double, longitude: Double): String {

        val result = java.lang.StringBuilder()
        try {
            val geocoder = Geocoder(context, Locale.getDefault())
            val addresses: List<Address> = geocoder.getFromLocation(latitude, longitude, 1)
            if (addresses.size > 0 && addresses != null)  {

                val address: Address = addresses[0]
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

}