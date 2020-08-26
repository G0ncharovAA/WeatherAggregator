package ru.gonchar17narod.weatheraggregator.data.dto.generated

import com.google.gson.annotations.SerializedName

data class BroadcastDTO(
    @SerializedName("base")
    val base: String,
    @SerializedName("clouds")
    val clouds: Clouds,
    @SerializedName("cod")
    val cod: String,
    @SerializedName("coord")
    val coord: Coord,
    @SerializedName("dt")
    val dt: Long,
    @SerializedName("id")
    val id: String,
    @SerializedName("main")
    val main: Main,
    @SerializedName("name")
    val name: String,
    @SerializedName("sys")
    val sys: Sys,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("visibility")
    val visibility: String,
    @SerializedName("weather")
    val weather: List<Weather>,
    @SerializedName("wind")
    val wind: Wind
) {
    data class Clouds(
        @SerializedName("all")
        val all: String
    )

    data class Coord(
        @SerializedName("lat")
        val lat: String,
        @SerializedName("lon")
        val lon: String
    )

    data class Main(
        @SerializedName("feels_like")
        val feelsLike: Double,
        @SerializedName("humidity")
        val humidity: String,
        @SerializedName("pressure")
        val pressure: String,
        @SerializedName("temp")
        val temp: Double,
        @SerializedName("temp_max")
        val tempMax: Double,
        @SerializedName("temp_min")
        val tempMin: Double
    )

    data class Sys(
        @SerializedName("country")
        val country: String,
        @SerializedName("id")
        val id: String,
        @SerializedName("sunrise")
        val sunrise: String,
        @SerializedName("sunset")
        val sunset: String,
        @SerializedName("type")
        val type: String
    )

    data class Weather(
        @SerializedName("description")
        val description: String,
        @SerializedName("icon")
        val icon: String,
        @SerializedName("id")
        val id: String,
        @SerializedName("main")
        val main: String
    )

    data class Wind(
        @SerializedName("deg")
        val deg: String,
        @SerializedName("speed")
        val speed: String
    )
}