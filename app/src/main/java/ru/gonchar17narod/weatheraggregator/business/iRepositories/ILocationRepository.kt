package ru.gonchar17narod.weatheraggregator.business.iRepositories

import android.location.Location
import kotlinx.coroutines.flow.Flow
import ru.gonchar17narod.weatheraggregator.business.DataState

interface ILocationRepository {

    fun getLocation(): Flow<DataState<Location>>
}