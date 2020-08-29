package ru.gonchar17narod.weatheraggregator.view.extensions

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun canGoBack(position: Int) =
    position > 0

fun canGoFurther(
    itemCount: Int,
    position: Int
) =
    itemCount > position + 1

fun Date.toStringFormat() =
    SimpleDateFormat(
        "dd MMMM yyyy\nEEEE",
        Locale.getDefault()
    ).format(this)

fun Double.temperatureFormat() =
    DecimalFormat(
        "##.#",
        DecimalFormatSymbols(Locale.US)
    ).apply {
        positivePrefix = "+"
        negativePrefix = "-"
    }.format(this)