package com.example.forecast.data.network

import androidx.lifecycle.LiveData
import com.example.forecast.data.network.responces.CurrentWeatherResponse

interface WeatherNetworkDataSource {

    val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String,
        languageCode: String
    )

    suspend fun fetchCurrentWeather(
        location: String
    )
}