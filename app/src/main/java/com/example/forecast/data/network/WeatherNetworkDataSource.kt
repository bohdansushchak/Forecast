package com.example.forecast.data.network

import androidx.lifecycle.LiveData
import com.example.forecast.data.network.responces.CurrentWeatherResponse
import com.example.forecast.data.network.responces.FutureWeatherResponse

interface WeatherNetworkDataSource {
    val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
    val downloadedFutureWeather: LiveData<FutureWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String,
        languageCode: String
    )
    suspend fun fetchFutureWeather(
        location: String,
        languageCode: String
    )
}