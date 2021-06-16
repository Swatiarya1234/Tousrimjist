package com.example.example.Core.factoryMethods

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.example.viewModel.mainActivityViewmodel

class mainActivityviewmodelFactory(): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(mainActivityViewmodel::class.java)){
            return mainActivityViewmodel() as T
        }
        throw IllegalArgumentException ("UnknownViewModel")
    }
}