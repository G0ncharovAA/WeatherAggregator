package ru.gonchar17narod.weatheraggregator.business.entities

import java.util.Date

data class WeatherEntity(
    val date: Date,
    val dayTime: DayTimes,
    val temp: Double,
    val sky: Drops
) {
    enum class Drops {
        CLEAR,
        CLOUDS,
        RAIN,
        SNOW
    }
}