package ru.gonchar17narod.weatheraggregator.view.screens.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.gonchar17narod.weatheraggregator.business.extensions.askForPermissions
import ru.gonchar17narod.weatheraggregator.business.extensions.checkPermissions
import ru.gonchar17narod.weatheraggregator.business.extensions.necessaryPermissionsGranted
import ru.gonchar17narod.weatheraggregator.view.extensions.initializeAdmob
import ru.gonchar17narod.weatheraggregator.view.extensions.navigateToMainScreen

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeAdmob()
    }

    override fun onStart() {
        super.onStart()

        if (checkPermissions()) {
            navigateToMainScreen()
        } else {
            askForPermissions()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (necessaryPermissionsGranted(requestCode, permissions, grantResults)) {
            navigateToMainScreen()
        } else {
            finish()
        }
    }
}