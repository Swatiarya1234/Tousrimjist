package com.example.example.core.gpsTracker

import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.work.*
import java.util.*
import java.util.concurrent.TimeUnit

object GpsTrackerWorkManager {

    @RequiresApi(Build.VERSION_CODES.M)
    fun refreshPeriodicWork(context: Context) {

        val currentDate = Calendar.getInstance()
        val dueDate = Calendar.getInstance()

        // Set Execution around 07:00:00 AM
        dueDate.set(Calendar.HOUR_OF_DAY, 7)
        dueDate.set(Calendar.MINUTE, 0)
        dueDate.set(Calendar.SECOND, 0)
        if (dueDate.before(currentDate)) {
            dueDate.add(Calendar.HOUR_OF_DAY, 15)
        }

        val timeDiff = dueDate.timeInMillis - currentDate.timeInMillis
        val minutes = TimeUnit.MILLISECONDS.toMinutes(timeDiff)

        Log.d("GpsTrackerWorkManager", "time difference $minutes")

        //define constraints
        val myConstraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresBatteryNotLow(true)
            .setRequiresDeviceIdle(true)
            .build()

        val refreshCpnWork = PeriodicWorkRequest.Builder(GpsTracker::class.java, 15, TimeUnit.MINUTES)
            .setInitialDelay(minutes, TimeUnit.MINUTES)
            .setConstraints(myConstraints)
            .addTag("GpsTrackerWorkManager")
            .build()

        WorkManager.getInstance(context).enqueueUniquePeriodicWork("GpsTrackerWorkManager",
            ExistingPeriodicWorkPolicy.REPLACE, refreshCpnWork)

    }
}