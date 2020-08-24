package ru.gonchar17narod.weatheraggregator.view.extensions

import ru.gonchar17narod.weatheraggregator.business.entities.DailyWeather
import ru.gonchar17narod.weatheraggregator.business.entities.WeatherEntity
import ru.gonchar17narod.weatheraggregator.business.extensions.toOneDigitFormat
import ru.gonchar17narod.weatheraggregator.view.vo.DailyWeatherVo
import ru.gonchar17narod.weatheraggregator.view.vo.WeatherVo
import java.text.SimpleDateFormat
import java.util.Date

fun WeatherEntity.toVo() =
    WeatherVo(
        temp = temp.toOneDigitFormat(),
        sky = sky
    )

fun DailyWeather.toVo() =
    DailyWeatherVo(
        date = date.toStringFormat(),
        conclusion = conclusion.toVo(),
        detailed = detailed.map {
            it.toVo()
        }
    )

private fun Date.toStringFormat() =
    SimpleDateFormat
        .getDateInstance()
        .format(this)