package ru.gonchar17narod.weatheraggregator.data.extensions

import ru.gonchar17narod.weatheraggregator.business.entities.WeatherEntity
import ru.gonchar17narod.weatheraggregator.business.extensions.dayTime
import ru.gonchar17narod.weatheraggregator.business.extensions.kelvinToCelsius
import ru.gonchar17narod.weatheraggregator.business.extensions.toCalendar
import ru.gonchar17narod.weatheraggregator.data.dto.generated.BroadcastDTO
import ru.gonchar17narod.weatheraggregator.data.dto.generated.ForecastDTO

fun BroadcastDTO.toWeatherEntity() =
    WeatherEntity(
        date = dt.unixTimeToDate(),
        dayTime = dt.unixTimeToDate().toCalendar().dayTime(),
        temp = main.temp.kelvinToCelsius(),
        sky = weather.firstOrNull()?.main.toSkyType()
    )

fun ForecastDTO.toWeatherEntities() =
    list.map {
        WeatherEntity(
            date = it.dt.unixTimeToDate(),
            dayTime = it.dt.unixTimeToDate().toCalendar().dayTime(),
            temp = it.main.temp.kelvinToCelsius(),
            sky = it.weather.firstOrNull()?.main.toSkyType()
        )
    }