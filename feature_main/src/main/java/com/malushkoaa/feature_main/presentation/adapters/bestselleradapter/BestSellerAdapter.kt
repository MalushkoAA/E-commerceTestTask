package com.malushkoaa.feature_main.presentation.adapters.bestselleradapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.malushkoaa.feature_main.R
import com.malushkoaa.feature_main.databinding.ItemBestSellerBinding
import com.malushkoaa.feature_main.domain.entities.BestSeller

class BestSellerAdapter(private val context: Context?) :
    ListAdapter<BestSeller, BestSellerViewHolder>(BestSellerDiffCallback) {
    
    var onBestSellerClick: ((BestSeller) -> Unit)? = null
    var onFavoriteClick: ((BestSeller) -> Unit)? = null
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellerViewHolder {
        val binding = ItemBestSellerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return BestSellerViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder: BestSellerViewHolder, position: Int) {
        val resources = context?.resources
        val bestSellerItems = getItem(position)
        with(holder.binding) {
            with(bestSellerItems) {
                tvDiscountPrice.text = resources?.getString(
                    R.string.best_seller_discount_price, this.discountPrice
                )
                tvPriceWithoutDiscount.text = resources?.getString(
                    R.string.best_seller_price, this.priceWithoutDiscount
                )
                rvTvDescription.text = title
                Glide.with(ivPhone.context)
                    .load(picture)
                    .apply(
                        RequestOptions()
                            .placeholder(com.malushkoaa.core.R.drawable.loading_animation)
                            .error(com.malushkoaa.core.R.drawable.ic_broken_image)
                    )
                    .fitCenter()
                    .into(ivPhone)
                if (isFavorites == true) btnFavorite.setIconResource(com.malushkoaa.core.R.drawable.ic_favorite)
                btnFavorite.setOnClickListener {
                    if (isFavorites == true) {
                        btnFavorite.setIconResource(com.malushkoaa.core.R.drawable.ic_favorite_not)
                    } else {
                        btnFavorite.setIconResource(com.malushkoaa.core.R.drawable.ic_favorite)
                    }
                    onFavoriteClick?.invoke(this)
                }
                root.setOnClickListener {
                    onBestSellerClick?.invoke(this)
                }
            }
        }
    }
}

