package ru.gonchar17narod.weatheraggregator.view.screens.main

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.gonchar17narod.weatheraggregator.business.DataState
import ru.gonchar17narod.weatheraggregator.business.useCases.GetWeatherUseCase
import ru.gonchar17narod.weatheraggregator.view.extensions.toVo
import ru.gonchar17narod.weatheraggregator.view.vo.DailyWeatherVo

class MainViewModel @ViewModelInject constructor(
    private val weatherInteractor: GetWeatherUseCase,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _liveProgress = MutableLiveData<Boolean>()
    val liveProgress: MutableLiveData<Boolean>
        get() = _liveProgress

    private val _liveDailyWeatherVo = MutableLiveData<List<DailyWeatherVo>>()
    val liveDailyWeatherVo: MutableLiveData<List<DailyWeatherVo>>
        get() = _liveDailyWeatherVo

    private val _liveErrorVo = MutableLiveData<Exception>()
    val liveErrorVo: MutableLiveData<Exception>
        get() = _liveErrorVo

    val textState = MutableLiveData<String>()

    init {
        getWeather()
    }

    private fun getWeather() =
        viewModelScope.launch {
            weatherInteractor.getWeather().collect {
                when (it) {
                    is DataState.Loading -> {
                        _liveProgress.postValue(true)
                        textState.postValue("Loading")
                    }
                    is DataState.Success -> {
                        with(
                            it.data.map {
                                it.toVo()
                            }
                        ) {
                            _liveDailyWeatherVo.postValue(this)
                            _liveProgress.postValue(false)
                            textState.postValue("success : ${this.size} days loaded")
                        }
                    }
                    is DataState.Error -> {
                        _liveErrorVo.postValue(it.exception)
                        _liveProgress.postValue(false)
                        textState.postValue("error : ${it.exception.message}")
                    }
                }
            }
        }
}