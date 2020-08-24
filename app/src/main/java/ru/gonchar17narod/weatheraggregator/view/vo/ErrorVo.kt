package ru.gonchar17narod.weatheraggregator.view.vo

sealed class ErrorVo {

    class PermissionError(): ErrorVo()
    class LocationError(): ErrorVo()
    class NetworkError(): ErrorVo()
    class UnknownError(): ErrorVo()
}