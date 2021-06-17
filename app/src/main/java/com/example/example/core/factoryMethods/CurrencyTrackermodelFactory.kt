package com.example.example.core.factoryMethods

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CurrencyTrackermodelFactory(): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CurrencyTrackermodelFactory::class.java)){
            return CurrencyTrackermodelFactory() as T
        }
        throw IllegalArgumentException ("UnknownViewModel")
    }
}