package com.example.example.core.gpsTracker.delegate

import com.example.example.core.weather.RestClient
import com.example.example.core.weather.pojoClasses.WeatherMain
import kotlin.properties.Delegates.observable
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class GpsProperties(latitude:Double,longitude: Double,countryName:String){
    var latitude:Double
    var longitude : Double
    var countryName:String
    init{
        this.latitude = latitude
        this.longitude = longitude
        this.countryName = countryName
    }

}
class GpsDelegate {
    var gpsProperties: GpsProperties by observable() { property, oldValue, newValue ->

    }

    private fun observable(onChange: (property: KProperty<*>, oldValue: GpsProperties, newValue: GpsProperties) -> Unit) {
        RestClient.getWeatherData(gpsProperties.latitude,gpsProperties.longitude)
    }

}

private operator fun Any.setValue(gpsDelegate: GpsDelegate, property: KProperty<*>, gpsProperties: GpsProperties) {

}

private operator fun Unit.getValue(gpsDelegate: GpsDelegate, property: KProperty<*>): GpsProperties {
    return  gpsDelegate.gpsProperties
}
