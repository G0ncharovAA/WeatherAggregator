package ru.gonchar17narod.weatheraggregator.view.screens.main.items

import com.xwray.groupie.databinding.BindableItem
import ru.gonchar17narod.weatheraggregator.R
import ru.gonchar17narod.weatheraggregator.databinding.ItemDailyWeatherBinding
import ru.gonchar17narod.weatheraggregator.view.vo.DailyWeatherVo

class DayItem(
    private val dailyWeatherVo: DailyWeatherVo
) : BindableItem<ItemDailyWeatherBinding>() {

    override fun getLayout() = R.layout.item_daily_weather

    override fun bind(viewBinding: ItemDailyWeatherBinding, position: Int) {
        with(viewBinding) {
            dailyWeatherVo = this@DayItem.dailyWeatherVo
        }
    }
}