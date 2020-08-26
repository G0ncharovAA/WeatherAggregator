package ru.gonchar17narod.weatheraggregator.view.extensions

import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar

fun ViewGroup.makeSnackbar(message: String) =
    Snackbar.make(
        this,
        message,
        Snackbar.LENGTH_SHORT
    )