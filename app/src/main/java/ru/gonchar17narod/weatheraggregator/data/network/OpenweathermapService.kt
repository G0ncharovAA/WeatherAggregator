package ru.gonchar17narod.weatheraggregator.data.network

import retrofit2.http.GET
import retrofit2.http.Query
import ru.gonchar17narod.weatheraggregator.data.dto.generated.BroadcastDTO
import ru.gonchar17narod.weatheraggregator.data.dto.generated.ForecastDTO

interface OpenweathermapService {

    @GET("/data/2.5/weather")
    suspend fun getBroadcast(
        @Query("lat") latitude: String,
        @Query("lon") longitude: String
    ): BroadcastDTO

    @GET("/data/2.5/forecast")
    suspend fun getForecast(
        @Query("lat") latitude: String,
        @Query("lon") longitude: String
    ): ForecastDTO
}