package com.example.example.Core.factoryMethods

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class currencyTrackermodelFactory(): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(currencyTrackermodelFactory::class.java)){
            return currencyTrackermodelFactory() as T
        }
        throw IllegalArgumentException ("UnknownViewModel")
    }
}