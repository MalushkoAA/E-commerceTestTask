package com.malushkoaa.feature_my_cart.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.malushkoaa.feature_my_cart.databinding.ItemCartBinding
import com.malushkoaa.feature_my_cart.domain.entities.ItemBasket
import java.text.DecimalFormat

class CartAdapter : ListAdapter<ItemBasket, CartViewHolder>(CartDiffCallback) {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = ItemCartBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CartViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item = getItem(position)
        with(holder.binding) {
            with(item) {
                tvProdName.text = title
                tvPrice.text = formattedPrice(item.price)
                Glide.with(ivProduct.context)
                    .load(images)
                    .apply(
                        RequestOptions()
                            .placeholder(com.malushkoaa.core.R.drawable.loading_animation)
                            .error(com.malushkoaa.core.R.drawable.ic_broken_image)
                    )
                    .into(ivProduct)
            }
        }
    }
    
    private fun formattedPrice(price: Int?): String {
        val strPrice = price.toString()
        if (strPrice.length == 3) {
            return "$${DecimalFormat("###.00").format(strPrice.toInt())}"
        }
        if (strPrice.length == 4) {
            return "$${DecimalFormat("#,###.00").format(strPrice.toInt())}"
        } else {
            return "$${DecimalFormat("##,###.00").format(strPrice.toInt())}"
        }
    }
    
}

