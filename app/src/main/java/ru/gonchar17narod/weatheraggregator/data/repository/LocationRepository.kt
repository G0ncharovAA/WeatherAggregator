package ru.gonchar17narod.weatheraggregator.data.repository

import android.annotation.SuppressLint
import android.location.Location
import com.google.android.gms.location.FusedLocationProviderClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import ru.gonchar17narod.weatheraggregator.business.DataState
import ru.gonchar17narod.weatheraggregator.business.iRepositories.ILocationRepository
import ru.gonchar17narod.weatheraggregator.data.mocked.mockIfNull
import java.lang.Exception
import javax.inject.Inject

class LocationRepository @Inject constructor(
    val fusedLocationProviderClient: FusedLocationProviderClient
) : ILocationRepository {

    @ExperimentalCoroutinesApi
    @SuppressLint("MissingPermission")
    override fun getLocation(): Flow<DataState<Location>> =
        callbackFlow {
            try {
                with(
                    fusedLocationProviderClient.lastLocation
                ) {
                    addOnSuccessListener {
                        offer(DataState.Success(it.mockIfNull()))
                    }
                    addOnFailureListener {
                        offer(DataState.Error(it))
                    }
                }
                awaitClose {
                    cancel()
                }
            } catch (e: Exception) {
                offer(DataState.Error(e))
            }
        }.flowOn(Dispatchers.Main)
}