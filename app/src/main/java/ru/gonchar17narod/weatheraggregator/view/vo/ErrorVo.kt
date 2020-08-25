package ru.gonchar17narod.weatheraggregator.view.vo

sealed class ErrorVo(
    val embedException: Exception
) {

    class PermissionError(embedException: Exception): ErrorVo(embedException)
    class LocationError(embedException: Exception): ErrorVo(embedException)
    class NetworkError(embedException: Exception): ErrorVo(embedException)
    class UnknownError(embedException: Exception): ErrorVo(embedException)
}