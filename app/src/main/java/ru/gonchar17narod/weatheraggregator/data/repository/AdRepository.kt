package ru.gonchar17narod.weatheraggregator.data.repository

import ru.gonchar17narod.weatheraggregator.BuildConfig
import ru.gonchar17narod.weatheraggregator.business.entities.AdEntity
import ru.gonchar17narod.weatheraggregator.business.iRepositories.IAdRepository
import javax.inject.Inject

class AdRepository @Inject constructor() : IAdRepository {

    override suspend fun loadAdData(): AdEntity =
        AdEntity(BuildConfig.ADMOB_BANNER_ID)
}