package ru.gonchar17narod.weatheraggregator.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import ru.gonchar17narod.weatheraggregator.business.iRepositories.IWeatherRepository
import ru.gonchar17narod.weatheraggregator.business.interactors.GetWeatherInteractor
import ru.gonchar17narod.weatheraggregator.business.useCases.GetWeatherUseCase
import ru.gonchar17narod.weatheraggregator.data.repository.WeatherRepository

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class AppModule {

    @Binds
    @ActivityRetainedScoped
    abstract fun bindWeatherInteractor(
        weatherInteractor: GetWeatherInteractor
    ): GetWeatherUseCase

    @Binds
    @ActivityRetainedScoped
    abstract fun bindWeatherRepository(
        weatherRepository: WeatherRepository
    ): IWeatherRepository
}