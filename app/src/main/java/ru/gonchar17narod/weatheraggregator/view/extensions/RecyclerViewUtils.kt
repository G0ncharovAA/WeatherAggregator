package ru.gonchar17narod.weatheraggregator.view.extensions

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun Int.zeroIfNegative() =
    when {
        this < 0 -> 0
        else -> this
    }

fun RecyclerView.readyToScroll() =
    scrollState == RecyclerView.SCROLL_STATE_IDLE

fun LinearLayoutManager.positionScrollTo(direction: Int) =
    (findFirstCompletelyVisibleItemPosition() + direction).zeroIfNegative()

fun RecyclerView.smoothScrollForwards() =
    (layoutManager as? LinearLayoutManager)?.let {
        if (readyToScroll())
            smoothScrollToPosition(
                it.positionScrollTo(1)
            )
    }

fun RecyclerView.smoothScrollBackwards() =
    (layoutManager as? LinearLayoutManager)?.let {
        if (readyToScroll())
            smoothScrollToPosition(
                it.positionScrollTo(-1)
            )
    }