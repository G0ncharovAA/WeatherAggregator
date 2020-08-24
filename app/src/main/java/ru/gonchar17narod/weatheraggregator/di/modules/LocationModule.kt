package ru.gonchar17narod.weatheraggregator.di.modules

import android.content.Context
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped
import ru.gonchar17narod.weatheraggregator.business.iRepositories.ILocationRepository
import ru.gonchar17narod.weatheraggregator.data.repository.LocationRepository

@Module
@InstallIn(ActivityRetainedComponent::class)
class LocationModule {

    @Provides
    @ActivityRetainedScoped
    fun provideFusedLocationClient(
        @ApplicationContext context: Context
    ): FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    @Provides
    @ActivityRetainedScoped
    fun provideLocationRepository(
        fusedLocationProviderClient: FusedLocationProviderClient
    ): ILocationRepository =
        LocationRepository(fusedLocationProviderClient)
}