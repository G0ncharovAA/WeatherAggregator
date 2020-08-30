package ru.gonchar17narod.weatheraggregator.view.screens.main

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.xwray.groupie.Group
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.gonchar17narod.weatheraggregator.business.DataState
import ru.gonchar17narod.weatheraggregator.business.useCases.AdUseCase
import ru.gonchar17narod.weatheraggregator.business.useCases.GetWeatherUseCase
import ru.gonchar17narod.weatheraggregator.view.extensions.toDayItem
import ru.gonchar17narod.weatheraggregator.view.extensions.toVo
import ru.gonchar17narod.weatheraggregator.view.screens.main.items.AdItem
import ru.gonchar17narod.weatheraggregator.view.vo.ErrorVo

class MainViewModel @ViewModelInject constructor(
    private val weatherInteractor: GetWeatherUseCase,
    private val adInteractor: AdUseCase,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _liveProgress = MutableLiveData<Boolean>()
    val liveProgress: LiveData<Boolean>
        get() = _liveProgress

    private val _liveErrorVo = MutableLiveData<ErrorVo>()
    val liveErrorVo: LiveData<ErrorVo>
        get() = _liveErrorVo

    private val _liveContentGroups = MutableLiveData<List<Group>>()
    val liveContentGroups: LiveData<List<Group>>
        get() = _liveContentGroups

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
                                it
                                    .toVo()
                                    .toDayItem()
                            }
                                .plus(AdItem())
                                .shuffled()
                        ) {
                            _liveContentGroups.postValue(this)
                            _liveProgress.postValue(false)
                            textState.postValue("success : ${this.size} days loaded")
                        }
                    }
                    is DataState.Error -> {
                        _liveErrorVo.postValue(it.exception.toVo())
                        _liveProgress.postValue(false)
                        textState.postValue("error : ${it.exception.message}")
                    }
                }
            }
        }
}