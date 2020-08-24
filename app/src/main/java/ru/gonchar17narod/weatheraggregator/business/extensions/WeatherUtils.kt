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
    minusElement(this.first())

fun List<WeatherEntity>.filterNight() =
    filter {
        it.dayTime != DayTimes.NIGHT
    }

fun List<WeatherEntity>.filterEvening() =
    filter {
        it.dayTime != DayTimes.EVENING
    }

fun List<WeatherEntity>.makeConclusion() =
    WeatherEntity(
        date = first().date,
        dayTime = first().dayTime,
        temp = map { it.temp }.average(),
        sky = maxBy { it.sky.ordinal }?.sky ?: WeatherEntity.Drops.CLEAR
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
                this.first()
            )
        )
            .plus(
                this
                    .minusFirstElement()
                    .map {
                        DailyWeather(
                            it.first().date,
                            it
                                .filterNight()
                                .filterEvening()
                                .makeConclusion(),
                            it
                        )
                    }
            )
    }
