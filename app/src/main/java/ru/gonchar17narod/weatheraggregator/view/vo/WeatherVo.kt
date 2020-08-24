package ru.gonchar17narod.weatheraggregator.view.vo

import ru.gonchar17narod.weatheraggregator.business.entities.WeatherEntity

data class WeatherVo(
    val temp: String,
    val sky: WeatherEntity.Drops
)
