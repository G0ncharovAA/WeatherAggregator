package ru.gonchar17narod.weatheraggregator.utils

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Test
import ru.gonchar17narod.weatheraggregator.business.extensions.toTwoDigitsFormat

class NumbersTests {

    @Test
    fun DoubleFormatTest() {
        assertThat(
            3.1415926535.toTwoDigitsFormat(),
            equalTo("3,14")
        )
        assertThat(
            (-3.1415926535).toTwoDigitsFormat(),
            equalTo("-3,14")
        )
        assertThat(
            0.00000000001.toTwoDigitsFormat(),
            equalTo("0,00")
        )
        assertThat(
            120.00000000001.toTwoDigitsFormat(),
            equalTo("120,00")
        )
        assertThat(
            (-120.00000000001).toTwoDigitsFormat(),
            equalTo("-120,00")
        )
    }
}