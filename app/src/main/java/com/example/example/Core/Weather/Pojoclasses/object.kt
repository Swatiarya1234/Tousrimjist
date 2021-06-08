package com.example.example.Core.Weather.Pojoclasses

data class `object`(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
) {
    var basesecond: String = base
        get() = field
        set(value) {         // setter
            field = value
        }
    var cloudssecond: Clouds = clouds
        get() = field
        set(value) {
            field = value
        }
    var codsecond: Int = cod
        get() = field
        set(value) {
            field = value
        }
    var coords:Coord = coord
    get() = field
    set(value) {
        field = value
    }
    var dtsecond: Int = dt
        get() = field
        set(value) {
            field = value
        }
    var idsecond:Int = id
        get() = field
        set(value) {
            field = value
        }

    var mainSecond: Sys = sys
        get() = field
        set(value) {
            field = value
        }
    var timezonesecond: Int = timezone
        get() = field
        set(value) {
            field = value
        }
    var visibilitysecond: Int = visibility
        get() = field
        set(value) {
            field = value
        }

    var weathersecond: List<Weather> = weather
        get() = field
        set(value) {
            field = value
        }

    var windSecond :Wind = wind
        get() = field
        set(value) {
            field = value
        }

}