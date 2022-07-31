package com.malushkoaa.feature_main.presentation.adapters.hotsaleadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.malushkoaa.feature_main.databinding.ItemHotSaleBinding
import com.malushkoaa.feature_main.domain.entities.HotSale

class HotSaleAdapter() : ListAdapter<HotSale, HotSaleViewHolder>(HotSaleDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotSaleViewHolder {
        val binding = ItemHotSaleBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return HotSaleViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder: HotSaleViewHolder, position: Int) {
        val hotSaleItems = getItem(position)
        with(holder.binding) {
            fun labelNew(hotSaleItem: HotSale) {
                if (hotSaleItem.isNew != null) {
                    hotSalesLabel.visibility = View.VISIBLE
                    hotSalesLabelNewText.visibility = View.VISIBLE
                } else {
                    hotSalesLabel.visibility = View.GONE
                    hotSalesLabelNewText.visibility = View.GONE
                }
            }
            with(hotSaleItems) {
                tvTitle.text = title
                tvSubTitle.text = subtitle
                Glide.with(ivHotSales.context)
                    .load(picture)
                    .apply(
                        RequestOptions()
                            .placeholder(com.malushkoaa.core.R.drawable.loading_animation)
                            .error(com.malushkoaa.core.R.drawable.ic_broken_image)
                    )
                    .centerCrop()
                    .into(ivHotSales)
                labelNew(this)
            }
        }
    }
}
