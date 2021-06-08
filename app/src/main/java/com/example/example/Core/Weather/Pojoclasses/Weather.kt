package com.example.example.Core.Weather.Pojoclasses

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)
{
    var descriptionsecond: String = description
        get() = field
        set(value) {         // setter
            field = value
        }
    var iconsecond:String = icon
        get() = field
        set(value) {
            field =value
        }
    var pressuresecond:Int = id
        get() = field
        set(value) {
            field =value
        }
    var mainsecond:String = main
        get()  = field
        set(value) {
            field = value
        }
}