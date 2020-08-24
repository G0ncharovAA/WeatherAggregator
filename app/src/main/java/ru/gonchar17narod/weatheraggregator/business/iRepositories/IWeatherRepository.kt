package ru.gonchar17narod.weatheraggregator.business.iRepositories

import android.location.Location
import ru.gonchar17narod.weatheraggregator.business.entities.WeatherEntity

interface IWeatherRepository {

    suspend fun getBroadcast(forLocation: Location): WeatherEntity

    suspend fun getForecast(forLocation: Location): List<WeatherEntity>
}