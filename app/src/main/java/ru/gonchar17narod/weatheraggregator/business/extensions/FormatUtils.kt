package ru.gonchar17narod.weatheraggregator.business.extensions

import ru.gonchar17narod.weatheraggregator.business.entities.DayTimes
import java.util.*

fun Double.kelvinToCelsius() =
    this - 273

fun Double.format(digits: Int) =
    "%.${digits}f".format(this)

fun Double.toOneDigitFormat() =
    format(1)

fun Double.toTwoDigitsFormat() =
    format(2)

fun Date.toCalendar() =
    Calendar.getInstance().apply { time = this@toCalendar }

fun Calendar.day() =
    get(Calendar.DAY_OF_YEAR)

fun Calendar.dayTime() =
    when (get(Calendar.HOUR_OF_DAY)) {
        in (7..12) -> DayTimes.MORNING
        in (13..18) -> DayTimes.NOON
        in (19..23) -> DayTimes.EVENING
        else -> DayTimes.NIGHT
    }