package ru.gonchar17narod.weatheraggregator.data.mocked

import android.location.Location

fun mockLocation() =
    Location("Mocked").apply {
        latitude = 55.68
        longitude = 37.66
    }

fun Location?.mockIfNull() =
    this ?: mockLocation()