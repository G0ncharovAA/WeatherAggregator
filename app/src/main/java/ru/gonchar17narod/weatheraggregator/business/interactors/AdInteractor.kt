package ru.gonchar17narod.weatheraggregator.business.interactors

import ru.gonchar17narod.weatheraggregator.business.entities.AdEntity
import ru.gonchar17narod.weatheraggregator.business.iRepositories.IAdRepository
import ru.gonchar17narod.weatheraggregator.business.useCases.AdUseCase
import javax.inject.Inject

class AdInteractor @Inject constructor(
    val adRepository: IAdRepository
):  AdUseCase{

    override suspend fun getAd(): AdEntity =
        adRepository.loadAdData()
}