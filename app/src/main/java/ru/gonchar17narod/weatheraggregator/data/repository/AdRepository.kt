package ru.gonchar17narod.weatheraggregator.data.repository

import ru.gonchar17narod.weatheraggregator.business.entities.AdEntity
import ru.gonchar17narod.weatheraggregator.business.iRepositories.IAdRepository
import javax.inject.Inject

class AdRepository @Inject constructor(): IAdRepository {

    override suspend fun loadAdData(): AdEntity =
        AdEntity("mocked")
}