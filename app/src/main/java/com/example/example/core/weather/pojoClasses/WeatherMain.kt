package com.example.example.core.weather.pojoClasses

data class WeatherMain(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<list>,
    val message: Int
)