package ru.gonchar17narod.weatheraggregator.view

import androidx.test.core.app.launchActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import ru.gonchar17narod.weatheraggregator.view.screens.main.MainActivity

@HiltAndroidTest
class ViewTests {

    @get: Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun mainActivityTest(){
        val scenario = launchActivity<MainActivity>()
    }
}