package ru.gonchar17narod.weatheraggregator.data.repository

import android.location.Location
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.gonchar17narod.weatheraggregator.business.entities.WeatherEntity
import ru.gonchar17narod.weatheraggregator.business.iRepositories.IWeatherRepository
import ru.gonchar17narod.weatheraggregator.business.extensions.toTwoDigitsFormat
import ru.gonchar17narod.weatheraggregator.data.network.OpenweathermapService
import ru.gonchar17narod.weatheraggregator.data.extensions.toWeatherEntities
import ru.gonchar17narod.weatheraggregator.data.extensions.toWeatherEntity
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val openweathermapService: OpenweathermapService
) : IWeatherRepository {

    override suspend fun getBroadcast(forLocation: Location): WeatherEntity =
        withContext(Dispatchers.IO) {
            openweathermapService.getBroadcast(
                latitude = forLocation.latitude.toTwoDigitsFormat(),
                longitude = forLocation.longitude.toTwoDigitsFormat()
            ).toWeatherEntity()
        }

    override suspend fun getForecast(forLocation: Location): List<WeatherEntity> =
        withContext(Dispatchers.IO) {
            openweathermapService.getForecast(
                latitude = forLocation.latitude.toTwoDigitsFormat(),
                longitude = forLocation.longitude.toTwoDigitsFormat()
            ).toWeatherEntities()
        }
}