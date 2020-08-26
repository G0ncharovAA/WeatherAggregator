package ru.gonchar17narod.weatheraggregator.business.interactors

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import ru.gonchar17narod.weatheraggregator.business.DataState
import ru.gonchar17narod.weatheraggregator.business.entities.DailyWeather
import ru.gonchar17narod.weatheraggregator.business.iRepositories.ILocationRepository
import ru.gonchar17narod.weatheraggregator.business.iRepositories.IWeatherRepository
import ru.gonchar17narod.weatheraggregator.business.extensions.toDailyWeatherList
import ru.gonchar17narod.weatheraggregator.business.useCases.GetWeatherUseCase
import javax.inject.Inject

class GetWeatherInteractor @Inject constructor(
    private val locationRepository: ILocationRepository,
    private val weatherRepository: IWeatherRepository
) : GetWeatherUseCase {

    override suspend fun getWeather(): Flow<DataState<List<DailyWeather>>> =
        flow {
            emit(DataState.Loading)
            try {
                locationRepository
                    .getLocation()
                    .collect {
                        when (it) {
                            is DataState.Success -> {
                                emit(
                                    DataState.Success(
                                        weatherRepository.getForecast(
                                            it.data
                                        )
                                            .toDailyWeatherList(
                                                weatherRepository.getBroadcast(
                                                    it.data
                                                )
                                            )
                                    )
                                )
                            }
                            is DataState.Error ->
                                emit(DataState.Error(it.exception))
                        }
                    }
            } catch (e: Exception) {
                emit(DataState.Error(e))
            }
        }
}