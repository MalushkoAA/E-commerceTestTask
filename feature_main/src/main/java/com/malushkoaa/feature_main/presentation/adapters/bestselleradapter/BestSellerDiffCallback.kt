package com.malushkoaa.feature_main.presentation.adapters.bestselleradapter

import androidx.recyclerview.widget.DiffUtil
import com.malushkoaa.feature_main.domain.entities.BestSeller

object BestSellerDiffCallback : DiffUtil.ItemCallback<BestSeller>() {

    override fun areItemsTheSame(oldItem: BestSeller, newItem: BestSeller): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BestSeller, newItem: BestSeller): Boolean {
        return oldItem == newItem
    }
}