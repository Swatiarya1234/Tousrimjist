package com.example.example.Core.Weather.Pojoclasses

data class Main(
    val feels_like: Double,
    val humidity: Int,
    val pressure: Int,
    val temp: Double,
    val temp_max: Double,
    val temp_min: Double
){
    var feels_likesecond: Double = feels_like
        get() = field
        set(value) {         // setter
            field = value
        }
    var humiditysecond:Int = humidity
        get() = field
        set(value) {
            field =value
        }
    var pressuresecond:Int = pressure
        get() = field
        set(value) {
            field =value
        }
    var tempsecond:Double = temp
    get()  = field
    set(value) {
        field = value
    }
    var temp_maxsecond:Double = temp_max
        get()  = field
        set(value) {
            field = value
        }
    var temp_minsecond:Double = temp_min
       get() = field
       set(value) {
           field = value
       }

}