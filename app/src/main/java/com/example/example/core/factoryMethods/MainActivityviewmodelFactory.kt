package com.example.example.core.factoryMethods

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.example.viewModel.MainActivityViewmodel

class MainActivityviewmodelFactory(): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainActivityViewmodel::class.java)){
            return MainActivityViewmodel() as T
        }
        throw IllegalArgumentException ("UnknownViewModel")
    }
}