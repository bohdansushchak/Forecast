package com.example.forecast.data.repository

import androidx.lifecycle.LiveData
import com.example.forecast.data.db.entity.WeatherLocation
import com.example.forecast.data.db.unitlocalized.current.UnitSpecificCurrentWeatherEntry
import com.example.forecast.data.db.unitlocalized.future.UnitSpecificSimpleFutureWeatherEntry
import org.threeten.bp.LocalDate

interface ForecastRepository {

    suspend fun getCurrentWeather(metric: Boolean): LiveData<out UnitSpecificCurrentWeatherEntry>

    suspend fun getFutureWeatherList(startDate: LocalDate, metric: Boolean): LiveData<out List<UnitSpecificSimpleFutureWeatherEntry>>

    suspend fun getWeatherLocation(): LiveData<WeatherLocation>
}