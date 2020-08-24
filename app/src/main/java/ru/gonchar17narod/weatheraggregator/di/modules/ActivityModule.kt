package ru.gonchar17narod.weatheraggregator.di.modules

import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class ActivityModule {

    @Provides
    @ActivityScoped
    fun provideSnapHelper(): SnapHelper =
        PagerSnapHelper()

    @Provides
    @ActivityScoped
    fun provideGroupieAdapter(): GroupAdapter<GroupieViewHolder> =
        GroupAdapter()
}