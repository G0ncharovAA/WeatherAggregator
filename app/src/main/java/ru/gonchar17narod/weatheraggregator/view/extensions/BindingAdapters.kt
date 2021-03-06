package ru.gonchar17narod.weatheraggregator.view.extensions

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.Group
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import ru.gonchar17narod.weatheraggregator.R
import ru.gonchar17narod.weatheraggregator.business.entities.DayTimes
import ru.gonchar17narod.weatheraggregator.business.entities.WeatherEntity
import ru.gonchar17narod.weatheraggregator.view.screens.main.items.DetailedItem
import ru.gonchar17narod.weatheraggregator.view.vo.ErrorVo

@BindingAdapter("app:textState")
fun TextView.textState(
    state: String?
) {
    text = state
}

@BindingAdapter("app:skyBackgroundHeader")
fun View.skyBackgroundHeader(sky: WeatherEntity.Drops) {
    background = context.getDrawable(
        when (sky) {
            WeatherEntity.Drops.CLEAR -> R.drawable.gradient_clear_header
            WeatherEntity.Drops.CLOUDS -> R.drawable.gradient_clouds_header
            WeatherEntity.Drops.RAIN -> R.drawable.gradient_rain_header
            WeatherEntity.Drops.SNOW -> R.drawable.gradient_snow_header
        }
    )
}

@BindingAdapter("app:skyBackground")
fun View.skyBackground(sky: WeatherEntity.Drops) {
    background = context.getDrawable(
        when (sky) {
            WeatherEntity.Drops.CLEAR -> R.drawable.gradient_clear_background
            WeatherEntity.Drops.CLOUDS -> R.drawable.gradient_clouds_background
            WeatherEntity.Drops.RAIN -> R.drawable.gradient_rain_background
            WeatherEntity.Drops.SNOW -> R.drawable.gradient_snow_background
        }
    )
}

@BindingAdapter("app:setGroupContent")
fun RecyclerView.setGroupContent(
    content: List<Group>?
) {
    content?.let {
        (adapter as? GroupAdapter)
            ?.updateAsync(content)
    }
}

@BindingAdapter("app:weatherDetailed")
fun RecyclerView.weatherDetailed(
    weatherDetailedItems: List<DetailedItem>
) {
    adapter =
        ((adapter ?: GroupAdapter<GroupieViewHolder>()) as? GroupAdapter)?.apply {
            update(weatherDetailedItems)
        }
}

@BindingAdapter("app:skyIcon")
fun ImageView.skyIcon(sky: WeatherEntity.Drops) =
    setImageResource(
        when (sky) {
            WeatherEntity.Drops.CLEAR -> R.drawable.ic_clear
            WeatherEntity.Drops.CLOUDS -> R.drawable.ic_clouds
            WeatherEntity.Drops.RAIN -> R.drawable.ic_rain
            WeatherEntity.Drops.SNOW -> R.drawable.ic_snow
        }
    )

@BindingAdapter("app:skyText")
fun TextView.skyText(sky: WeatherEntity.Drops) {
    text = context.getString(
        when (sky) {
            WeatherEntity.Drops.CLEAR -> R.string.status_clear
            WeatherEntity.Drops.CLOUDS -> R.string.status_clouds
            WeatherEntity.Drops.RAIN -> R.string.status_rain
            WeatherEntity.Drops.SNOW -> R.string.status_snow
        }
    )
}

@BindingAdapter("app:temp")
fun TextView.temp(temp: String) {
    text = context.getString(R.string.temp_pattern).format(temp)
}

@BindingAdapter("app:dayTime")
fun TextView.daytime(dayTime: DayTimes) {
    text = context.getString(
        when (dayTime) {
            DayTimes.NIGHT -> R.string.night
            DayTimes.MORNING -> R.string.morning
            DayTimes.NOON -> R.string.noon
            DayTimes.EVENING -> R.string.evening
        }
    )
}

@BindingAdapter("app:snackbarValues")
fun ViewGroup.snackbarValues(
    error: ErrorVo?
) =
    error?.apply {
        makeSnackbar(
            this@snackbarValues.context.getString(
                when (error) {
                    is ErrorVo.NetworkError -> R.string.error_network
                    is ErrorVo.LocationError -> R.string.error_location
                    is ErrorVo.PermissionError -> R.string.error_permission
                    is ErrorVo.UnknownError -> R.string.error_unknown
                }
            )
        ).show()
    }