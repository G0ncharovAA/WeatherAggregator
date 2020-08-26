package ru.gonchar17narod.weatheraggregator.business.useCases

import kotlinx.coroutines.flow.Flow
import ru.gonchar17narod.weatheraggregator.business.DataState
import ru.gonchar17narod.weatheraggregator.business.entities.DailyWeather

interface GetWeatherUseCase {

    suspend fun getWeather():  Flow<DataState<List<DailyWeather>>>
}