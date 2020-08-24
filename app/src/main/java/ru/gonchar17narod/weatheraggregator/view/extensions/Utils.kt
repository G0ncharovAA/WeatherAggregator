package ru.gonchar17narod.weatheraggregator.view.extensions

fun canGoBack(position: Int) =
    position > 0

fun canGoFurther(
    itemCount: Int,
    position: Int
) =
    itemCount < position + 1