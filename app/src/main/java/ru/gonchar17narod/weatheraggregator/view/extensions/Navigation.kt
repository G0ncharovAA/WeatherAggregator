package ru.gonchar17narod.weatheraggregator.view.extensions

import android.app.Activity
import android.content.Intent
import ru.gonchar17narod.weatheraggregator.view.screens.main.MainActivity

fun Activity.navigateToMainScreen() {
    startActivity(
        Intent(
            this,
            MainActivity::class.java
        )
    )
    finish()
}