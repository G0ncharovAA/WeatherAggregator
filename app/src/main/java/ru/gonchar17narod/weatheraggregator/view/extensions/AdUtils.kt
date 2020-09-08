package ru.gonchar17narod.weatheraggregator.view.extensions

import android.content.Context
import com.google.android.gms.ads.MobileAds

fun Context.initializeAdmob() =
    MobileAds.initialize(this)