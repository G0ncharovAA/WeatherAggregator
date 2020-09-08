package ru.gonchar17narod.weatheraggregator.view.screens.main.items

import android.util.Log
import android.view.View
import android.widget.TextView
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_ad.view.*
import ru.gonchar17narod.weatheraggregator.R
import ru.gonchar17narod.weatheraggregator.business.entities.AdEntity

class AdItem(
    private val adEntity: AdEntity
) : Item() {

    override fun getLayout(): Int = R.layout.item_ad

    override fun createViewHolder(itemView: View): GroupieViewHolder {
        Log.i("MyAd: ", "Created")
        return super.createViewHolder(itemView).apply {
            itemView.item_ad_container.addView(
                TextView(itemView.context).apply {
                    text = "Happy coding!"
                }
            )
        }
    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        Log.i("MyAd: ", "Binded")
    }

    override fun unbind(viewHolder: GroupieViewHolder) {
        super.unbind(viewHolder)
        Log.i("MyAd: ", "Unbinded")
    }
}