package ru.gonchar17narod.weatheraggregator.view.vo

import ru.gonchar17narod.weatheraggregator.business.entities.DayTimes
import ru.gonchar17narod.weatheraggregator.business.entities.WeatherEntity

data class WeatherVo(
    val dayTime: DayTimes,
    val temp: String,
    val sky: WeatherEntity.Drops
)