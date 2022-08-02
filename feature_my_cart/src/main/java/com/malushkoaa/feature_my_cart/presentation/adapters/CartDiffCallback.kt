package com.malushkoaa.feature_my_cart.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.malushkoaa.feature_my_cart.domain.entities.ItemBasket


object CartDiffCallback : DiffUtil.ItemCallback<ItemBasket>() {
    
    override fun areItemsTheSame(oldItem: ItemBasket, newItem: ItemBasket): Boolean {
        return oldItem.id == newItem.id
    }
    
    override fun areContentsTheSame(oldItem: ItemBasket, newItem: ItemBasket): Boolean {
        return oldItem == newItem
    }
}