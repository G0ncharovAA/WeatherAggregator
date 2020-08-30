package ru.gonchar17narod.weatheraggregator.view.screens.main.items

import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import ru.gonchar17narod.weatheraggregator.R
import ru.gonchar17narod.weatheraggregator.business.entities.AdEntity

class AdItem(
    private val adEntity: AdEntity
) : Item() {

    override fun getLayout(): Int = R.layout.item_ad

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {

    }
}