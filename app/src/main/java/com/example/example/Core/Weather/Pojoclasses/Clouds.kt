package com.example.example.Core.Weather.Pojoclasses

data class Clouds(
    val all: Int
    ){
    var lattide: Int = all
        get() = field
        set(value) {         // setter
            field = value
        }
}