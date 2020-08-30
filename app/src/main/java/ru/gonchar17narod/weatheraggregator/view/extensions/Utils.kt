package ru.gonchar17narod.weatheraggregator.view.extensions

import com.xwray.groupie.Group
import ru.gonchar17narod.weatheraggregator.business.entities.AdEntity
import ru.gonchar17narod.weatheraggregator.view.screens.main.items.AdItem
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.random.Random

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

fun List<Group>.randomPosiotionInTheMiddle() =
    Random.nextInt(
        from = 1,
        until = this.size - 1
    )

fun List<Group>.insertElement(position: Int, element: Group) =
    subList(0, position)
        .plus(element)
        .plus(
            this.subList(
                position,
                this.size
            )
        )

fun List<Group>.addAdItem(ad: AdEntity) =
    insertElement(
        if (size < 3) {
            1
        } else {
            randomPosiotionInTheMiddle()
        },
        AdItem(ad)
    )