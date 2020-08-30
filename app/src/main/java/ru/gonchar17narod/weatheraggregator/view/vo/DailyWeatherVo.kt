package ru.gonchar17narod.weatheraggregator.view.vo

import ru.gonchar17narod.weatheraggregator.view.screens.main.items.DetailedItem

data class DailyWeatherVo(
    val date: String,
    val conclusion: WeatherVo,
    val detailed: List<DetailedItem>
)