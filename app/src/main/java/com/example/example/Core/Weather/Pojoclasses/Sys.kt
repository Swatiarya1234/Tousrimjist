package com.example.example.Core.Weather.Pojoclasses

data class Sys(
    val country: String,
    val id: Int,
    val sunrise: Int,
    val sunset: Int,
    val type: Int
){
    var countrysecond: String = country
        get() = field
        set(value) {         // setter
            field = value
        }
    var humiditysecond:Int = id
        get() = field
        set(value) {
            field =value
        }
    var pressuresecond:Int = sunrise
        get() = field
        set(value) {
            field =value
        }
    var sunsetsecond:Int = sunrise
        get()  = field
        set(value) {
            field = value
        }
    var typesecond:Int = type
        get()  = field
        set(value) {
            field = value
        }

}