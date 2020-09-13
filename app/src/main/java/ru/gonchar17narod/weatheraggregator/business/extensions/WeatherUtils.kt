package ru.gonchar17narod.weatheraggregator.business.extensions

import ru.gonchar17narod.weatheraggregator.business.entities.DailyWeather
import ru.gonchar17narod.weatheraggregator.business.entities.DayTimes
import ru.gonchar17narod.weatheraggregator.business.entities.WeatherEntity

fun List<WeatherEntity>.groupByDay() =
    groupBy {
        it.date.toCalendar().day()
    }

fun List<WeatherEntity>.groupByDayTime() =
    groupBy {
        it.dayTime
    }

fun List<List<WeatherEntity>>.minusFirstElement() =
    minusElement(first())

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
                first()
            )
        )
            .plus(
                this
                    .minusFirstElement()
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