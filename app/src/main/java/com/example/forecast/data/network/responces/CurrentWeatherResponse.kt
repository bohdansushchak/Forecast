package com.example.forecast.data.network.responces

import com.example.forecast.data.db.entity.CurrentWeatherEntry
import com.example.forecast.data.db.entity.Location
import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,
    @SerializedName("location")
    val location: Location
)