package ru.gonchar17narod.weatheraggregator.business.extensions

import ru.gonchar17narod.weatheraggregator.business.entities.DailyWeather
import ru.gonchar17narod.weatheraggregator.business.entities.DayTimes
import ru.gonchar17narod.weatheraggregator.business.entities.WeatherEntity
import java.util.Date

fun List<WeatherEntity>.groupByDay() =
    groupBy {
        it.date.toCalendar().day()
    }

fun List<WeatherEntity>.groupByDayTime() =
    groupBy {
        it.dayTime
    }

fun List<List<WeatherEntity>>.minusContainsCurrentDayDetails(currentDay: Date) =
    when(first().first().date.toCalendar().isTheSameDay(currentDay.toCalendar())) {
        true -> minusElement(first())
        else -> this
    }

fun List<WeatherEntity>.filterNight() =
    filter {
        it.dayTime != DayTimes.NIGHT
    }

fun List<WeatherEntity>.filterEvening() =
    filter {
        it.dayTime != DayTimes.EVENING
    }

fun List<WeatherEntity>.filterDayTimes() =
    this
        .filterNight()
        .filterEvening()

fun List<List<WeatherEntity>>.currentDayDetials(currentDay: Date) =
    when(first().first().date.toCalendar().isTheSameDay(currentDay.toCalendar())) {
        true -> first()
        else -> emptyList()
    }

fun List<List<WeatherEntity>>.filterValidDays() =
    filter {
        it.filterDayTimes().isNotEmpty()
    }

fun List<WeatherEntity>.makeConclusion() =
    WeatherEntity(
        date = first().date,
        dayTime = first().dayTime,
        temp = map { it.temp }.average(),
        sky = maxByOrNull { it.sky.ordinal }?.sky ?: WeatherEntity.Drops.CLEAR
    )

fun List<WeatherEntity>.concludeForecast() =
    groupByDay()
        .map {
            it.value.groupByDayTime()
                .map {
                    it.value.makeConclusion()
                }
        }.sortedBy {
            it.first().date.time
        }

fun List<WeatherEntity>.toDailyWeatherList(
    currentWeather: WeatherEntity
) =
    with(concludeForecast()) {
        listOf(
            DailyWeather(
                currentWeather.date,
                currentWeather,
                currentDayDetials(currentWeather.date)
            )
        )
            .plus(
                this
                    .minusContainsCurrentDayDetails(currentWeather.date)
                    .filterValidDays()
                    .map {
                        DailyWeather(
                            it.first().date,
                            it
                                .filterDayTimes()
                                .makeConclusion(),
                            it
                        )
                    }
            )
    }