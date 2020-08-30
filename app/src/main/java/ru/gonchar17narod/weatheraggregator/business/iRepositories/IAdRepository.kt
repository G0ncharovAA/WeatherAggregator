package ru.gonchar17narod.weatheraggregator.business.iRepositories

import ru.gonchar17narod.weatheraggregator.business.entities.AdEntity

interface IAdRepository {

    suspend fun loadAdData(): AdEntity
}