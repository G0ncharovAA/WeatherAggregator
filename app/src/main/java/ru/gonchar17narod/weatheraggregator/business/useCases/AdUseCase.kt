package ru.gonchar17narod.weatheraggregator.business.useCases

import ru.gonchar17narod.weatheraggregator.business.entities.AdEntity

interface AdUseCase {

    suspend fun getAd(): AdEntity
}