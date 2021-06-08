package com.example.example.Core.Weather.Pojoclasses

data class Wind(
    val deg: Int,
    val gust: Double,
    val speed: Double
){
    var degsecond: Int = deg
        get() = field
        set(value) {         // setter
            field = value
        }
    var gustsecond:Double = gust
        get() = field
        set(value) {
            field =value
        }
    var speedsecond:Double = speed
        get() = field
        set(value) {
            field =value
        }
}