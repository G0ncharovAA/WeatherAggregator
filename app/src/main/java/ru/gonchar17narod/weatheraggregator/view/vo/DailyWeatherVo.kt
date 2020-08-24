package ru.gonchar17narod.weatheraggregator.view.vo

data class DailyWeatherVo(
    val date: String,
    val conclusion: WeatherVo,
    val detailed: List<WeatherVo>
)