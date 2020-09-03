package ru.gonchar17narod.weatheraggregator.view.screens.main.items

import android.util.Log
import android.view.View
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import ru.gonchar17narod.weatheraggregator.R
import ru.gonchar17narod.weatheraggregator.business.entities.AdEntity

class AdItem(
    private val adEntity: AdEntity
) : Item() {

    override fun getLayout(): Int = R.layout.item_ad

    override fun createViewHolder(itemView: View): GroupieViewHolder {
        Log.i("MyAd: ", "Created")
        return super.createViewHolder(itemView)
    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
            Log.i("MyAd: ", "Binded")
    }

    override fun unbind(viewHolder: GroupieViewHolder) {
        super.unbind(viewHolder)
        Log.i("MyAd: ", "Unbinded")
    }
}