package ru.gonchar17narod.weatheraggregator.data.extensions

import ru.gonchar17narod.weatheraggregator.business.entities.WeatherEntity
import java.util.*

fun Long.unixTimeToDate() =
    Date(this * 1000)

fun String?.toSkyType() =
    when (this) {
        "Clear" -> WeatherEntity.Drops.CLEAR
        "Clouds" -> WeatherEntity.Drops.CLOUDS
        "Rain" -> WeatherEntity.Drops.RAIN
        "Snow" -> WeatherEntity.Drops.SNOW
        else -> WeatherEntity.Drops.CLEAR
    }