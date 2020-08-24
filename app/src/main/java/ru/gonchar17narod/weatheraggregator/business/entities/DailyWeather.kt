package ru.gonchar17narod.weatheraggregator.business.entities

import java.util.Date

data class DailyWeather(
    val date: Date,
    val conclusion: WeatherEntity,
    val detailed: List<WeatherEntity>
)