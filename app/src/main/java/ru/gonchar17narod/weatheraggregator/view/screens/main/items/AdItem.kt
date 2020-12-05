package ru.gonchar17narod.weatheraggregator.view.screens.main.items

import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import com.google.android.gms.ads.*
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_ad.view.*
import ru.gonchar17narod.weatheraggregator.R
import ru.gonchar17narod.weatheraggregator.business.entities.AdEntity
import ru.gonchar17narod.weatheraggregator.view.extensions.observe

class AdItem(
    private val adEntity: AdEntity
) : Item() {

    override fun getLayout(): Int = R.layout.item_ad

    @SuppressLint("MissingPermission")
    override fun createViewHolder(itemView: View): GroupieViewHolder {
        Log.i("MyAd: ", "Created")
        return super.createViewHolder(itemView).apply {
            with(itemView.item_ad_container) {
                addView(
                    AdView(this.context).apply {
                        adSize = AdSize.MEDIUM_RECTANGLE
                        adUnitId = adEntity.bannerId
                        loadAd(
                            AdRequest.Builder().build()
                        )
                        //observe()
                    }
                )
            }
        }
    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        Log.i("ThisItem: ", "Binded")
    }

    override fun unbind(viewHolder: GroupieViewHolder) {
        super.unbind(viewHolder)
        Log.i("ThisItem: ", "Unbinded")
    }
}