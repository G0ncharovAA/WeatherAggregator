package ru.gonchar17narod.weatheraggregator.view.screens.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.SnapHelper
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import dagger.hilt.android.AndroidEntryPoint
import ru.gonchar17narod.weatheraggregator.R
import ru.gonchar17narod.weatheraggregator.databinding.ActivityMainBinding
import ru.gonchar17narod.weatheraggregator.view.extensions.smoothScrollBackwards
import ru.gonchar17narod.weatheraggregator.view.extensions.smoothScrollForwards
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    @Inject
    lateinit var groupAdapter: GroupAdapter<GroupieViewHolder>

    @Inject
    lateinit var snapHelper: SnapHelper

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        with(binding) {
            lifecycleOwner = this@MainActivity

            with(recyclerDays) {
                snapHelper.attachToRecyclerView(this)
                adapter = groupAdapter
                buttonRight.setOnClickListener {
                    smoothScrollForwards()
                }
                buttonLeft.setOnClickListener {
                    smoothScrollBackwards()
                }
            }

            mainviewmodel = mainViewModel
        }
    }
}