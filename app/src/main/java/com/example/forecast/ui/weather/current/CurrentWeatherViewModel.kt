package com.example.forecast.ui.weather.current


import com.example.forecast.data.provider.UnitProvider
import com.example.forecast.data.repository.ForecastRepository
import com.example.forecast.internal.lazyDeffered
import com.example.forecast.ui.base.WeatherViewModel

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weather by lazyDeffered {
        forecastRepository.getCurrentWeather(super.isMetricUnit)
    }
}
