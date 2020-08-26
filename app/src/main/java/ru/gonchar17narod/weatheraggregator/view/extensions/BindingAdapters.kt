package ru.gonchar17narod.weatheraggregator.view.extensions

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.GroupAdapter
import ru.gonchar17narod.weatheraggregator.R
import ru.gonchar17narod.weatheraggregator.view.screens.main.items.DayItem
import ru.gonchar17narod.weatheraggregator.view.vo.DailyWeatherVo
import ru.gonchar17narod.weatheraggregator.view.vo.ErrorVo

@BindingAdapter("app:textState")
fun TextView.textState(
    state: String?
) {
    text = state
}

@BindingAdapter("app:itemTextData")
fun TextView.itemTextData(
    dailyWeatherVo: DailyWeatherVo
) {
    text =
        "today: ${dailyWeatherVo.date} \n ${dailyWeatherVo.conclusion.temp} celsius \n sky is ${dailyWeatherVo.conclusion.sky}"
}

@BindingAdapter("app:shouldBeSeen")
fun View.shouldBeSeen(seen: Boolean) {
    visibility = if (seen)
        View.VISIBLE
    else
        View.GONE
}

@BindingAdapter("app:weatherDataVo")
fun RecyclerView.weatherDataVo(
    weatherData: List<DailyWeatherVo>?
) {
    weatherData?.apply {
        (adapter as? GroupAdapter)?.apply {
            clear()
            addAll(
                weatherData.map {
                    DayItem(it)
                }
            )
        }
    }
}

@BindingAdapter("app:snackbarValues")
fun ViewGroup.snackbarValues(
    error: ErrorVo?
) =
    error?.apply {
        makeSnackbar(
            when (error) {
                is ErrorVo.NetworkError -> this@snackbarValues.context.getString(R.string.error_network)
                is ErrorVo.LocationError -> this@snackbarValues.context.getString(R.string.error_location)
                is ErrorVo.PermissionError -> this@snackbarValues.context.getString(R.string.error_permission)
                is ErrorVo.UnknownError -> this@snackbarValues.context.getString(R.string.error_unknown)
            }
        ).show()
    }