package com.example.forecast.data.network.responces

import com.example.forecast.data.db.entity.WeatherLocation
import com.google.gson.annotations.SerializedName

data class FutureWeatherResponse(
    @SerializedName("forecast")
    val futureWeatherEntries: ForecastDaysContainer,
    @SerializedName("location")
    val location: WeatherLocation
)