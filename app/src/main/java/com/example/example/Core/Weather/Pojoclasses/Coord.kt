package com.example.example.Core.Weather.Pojoclasses

data class Coord(
    val lat: Double,
    val lon: Double
    ){
    var lattide: Double = lat
        get() = field
        set(value) {         // setter
            field = value
        }
    var longitude:Double = lattide
         get() = field
        set(value) {
            field =value
        }
}