package com.example.forecast.ui.weather.future.list

import com.example.forecast.data.provider.UnitProvider
import com.example.forecast.data.repository.ForecastRepository
import com.example.forecast.internal.lazyDeffered
import com.example.forecast.ui.base.WeatherViewModel
import org.threeten.bp.LocalDate

class FutureListWeatherViewModel(private val forecastRepository: ForecastRepository,
                                  unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weatherEntris by lazyDeffered {
        forecastRepository.getFutureWeatherList(LocalDate.now(), super.isMetricUnit)
    }
}
