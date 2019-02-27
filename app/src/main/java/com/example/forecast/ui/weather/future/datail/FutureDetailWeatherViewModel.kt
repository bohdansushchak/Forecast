package com.example.forecast.ui.weather.future.datail

import com.example.forecast.data.provider.UnitProvider
import com.example.forecast.data.repository.ForecastRepository
import com.example.forecast.internal.lazyDeffered
import com.example.forecast.ui.base.WeatherViewModel
import org.threeten.bp.LocalDate

class FutureDetailWeatherViewModel(
    private val detailDate: LocalDate,
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weather by lazyDeffered {
        forecastRepository.getFutureWeatherByDate(detailDate, super.isMetricUnit)
    }
}
