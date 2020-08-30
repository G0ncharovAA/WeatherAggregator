package ru.gonchar17narod.weatheraggregator.view.extensions

import ru.gonchar17narod.weatheraggregator.business.entities.DailyWeather
import ru.gonchar17narod.weatheraggregator.business.entities.WeatherEntity
import ru.gonchar17narod.weatheraggregator.business.extensions.LocationException
import ru.gonchar17narod.weatheraggregator.view.screens.main.items.DayItem
import ru.gonchar17narod.weatheraggregator.view.screens.main.items.DetailedItem
import ru.gonchar17narod.weatheraggregator.view.vo.DailyWeatherVo
import ru.gonchar17narod.weatheraggregator.view.vo.ErrorVo
import ru.gonchar17narod.weatheraggregator.view.vo.WeatherVo
import java.net.SocketTimeoutException
import java.net.UnknownHostException

fun DailyWeather.toVo() =
    DailyWeatherVo(
        date = date.toStringFormat(),
        conclusion = conclusion.toVo(),
        detailed = detailed.map {
            it
                .toVo()
                .toDetailedItem()
        }
    )

fun DailyWeatherVo.toDayItem() =
    DayItem(this)

fun WeatherEntity.toVo() =
    WeatherVo(
        dayTime = dayTime,
        temp = temp.temperatureFormat(),
        sky = sky
    )

fun WeatherVo.toDetailedItem() =
    DetailedItem(this)

fun Exception.toVo() =
    when (this) {
        is UnknownHostException -> ErrorVo.NetworkError(this)
        is SocketTimeoutException -> ErrorVo.NetworkError(this)
        is LocationException -> ErrorVo.LocationError(this)
        is SecurityException -> ErrorVo.PermissionError(this)
        else -> ErrorVo.UnknownError(this)
    }