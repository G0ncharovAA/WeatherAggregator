package ru.gonchar17narod.weatheraggregator.view.extensions

import android.content.Context
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds

fun Context.initializeAdmob() =
    MobileAds.initialize(this)

fun AdView.observe() {
    adListener = object : AdListener() {
        override fun onAdClosed() {
            super.onAdClosed()
        }

        override fun onAdFailedToLoad(p0: Int) {
            super.onAdFailedToLoad(p0)
        }

        override fun onAdFailedToLoad(p0: LoadAdError?) {
            super.onAdFailedToLoad(p0)
        }

        override fun onAdLeftApplication() {
            super.onAdLeftApplication()
        }

        override fun onAdOpened() {
            super.onAdOpened()
        }

        override fun onAdLoaded() {
            super.onAdLoaded()
        }

        override fun onAdClicked() {
            super.onAdClicked()
        }

        override fun onAdImpression() {
            super.onAdImpression()
        }
    }
}