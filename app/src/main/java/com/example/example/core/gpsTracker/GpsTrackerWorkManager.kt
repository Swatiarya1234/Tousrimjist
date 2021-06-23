package com.example.example.core.gpsTracker

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.work.*
import java.util.concurrent.TimeUnit

object GpsTrackerWorkManager {

    @RequiresApi(Build.VERSION_CODES.M)
    fun refreshPeriodicWork(context: Context) {

        //define constraints
//        val myConstraints = Constraints.Builder()
//            .setRequiredNetworkType(NetworkType.CONNECTED)
//            .setRequiresBatteryNotLow(true)
//            .setRequiresDeviceIdle(true)
//            .build()

        val refreshCpnWork = PeriodicWorkRequest.Builder(GpsTrackerWorker::class.java, 1, TimeUnit.SECONDS)
            .setInitialDelay(0, TimeUnit.MINUTES)
            .addTag("GpsTrackerWorkManager")
            .build()

        WorkManager.getInstance(context).enqueueUniquePeriodicWork("GpsTrackerWorkManager",
            ExistingPeriodicWorkPolicy.REPLACE, refreshCpnWork)

    }
}