package com.example.example.core.gpsTracker

import android.annotation.SuppressLint
import android.content.Context
import android.location.*
import android.os.Looper
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

class GpsTrackerWorker(val context: Context, workerParams: WorkerParameters) : CoroutineWorker(context, workerParams){
    private val mainContext:Context
    init{
         mainContext =  context
    }
    @SuppressLint("MissingPermission")
    fun requestLocationUpdate(){
        Looper.prepare()
        val  locationManager = mainContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager
         locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5f,
             GpsTracker.getInstance()!!)
        Looper.loop()
       //  Log.d("request location update","request location upadted")
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
        }
        catch (e: Exception) {
            Log.d("MyWorker", "exception in doWork ${e.message}")
            Result.failure()
        }
    }

}