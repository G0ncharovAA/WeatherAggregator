package ru.gonchar17narod.weatheraggregator.view.screens.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.SnapHelper
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import ru.gonchar17narod.weatheraggregator.R
import ru.gonchar17narod.weatheraggregator.databinding.ActivityMainBinding
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
            snapHelper.attachToRecyclerView(recycler_days)
            recyclerDays.adapter = groupAdapter

            mainviewmodel = mainViewModel
        }
    }
}