package com.malushkoaa.feature_main.presentation.adapters.hotsaleadapter

import androidx.recyclerview.widget.DiffUtil
import com.malushkoaa.feature_main.domain.entities.HotSale

object HotSaleDiffCallback : DiffUtil.ItemCallback<HotSale>() {
    override fun areItemsTheSame(oldItem: HotSale, newItem: HotSale): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: HotSale, newItem: HotSale): Boolean {
        return oldItem == newItem
    }
}