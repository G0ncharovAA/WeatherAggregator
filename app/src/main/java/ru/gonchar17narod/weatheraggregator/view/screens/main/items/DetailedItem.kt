package ru.gonchar17narod.weatheraggregator.view.screens.main.items

import com.xwray.groupie.databinding.BindableItem
import ru.gonchar17narod.weatheraggregator.R
import ru.gonchar17narod.weatheraggregator.databinding.ItemDetailedWeatherBinding
import ru.gonchar17narod.weatheraggregator.view.vo.WeatherVo

class DetailedItem(
    val weatherVo: WeatherVo
) : BindableItem<ItemDetailedWeatherBinding>() {

    override fun getLayout() = R.layout.item_detailed_weather

    override fun bind(binding: ItemDetailedWeatherBinding, position: Int) {
        with(binding) {

        }
    }
}