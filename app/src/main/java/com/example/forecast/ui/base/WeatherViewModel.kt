package com.example.forecast.ui.base

import androidx.lifecycle.ViewModel
import com.example.forecast.data.provider.UnitProvider
import com.example.forecast.data.repository.ForecastRepository
import com.example.forecast.internal.UnitSystem
import com.example.forecast.internal.lazyDeffered

abstract class WeatherViewModel(private val forecasrRepository: ForecastRepository,
                                unitProvider: UnitProvider): ViewModel() {

    private val unitSystem = unitProvider.getUnitSystem()

    val isMetricUnit: Boolean
    get() = unitSystem == UnitSystem.METRIC

    val weatherLocation by lazyDeffered {
        forecasrRepository.getWeatherLocation()
    }
}