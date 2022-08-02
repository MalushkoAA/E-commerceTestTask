package com.malushkoaa.feature_details.presentation.adapters.imagespager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.malushkoaa.feature_details.databinding.ItemDetailsAdapterBinding
import com.malushkoaa.feature_details.domain.entities.ItemColors

class ImagesAdapter() :
    RecyclerView.Adapter<ImagesViewHolder>() {
    
    var imagesList = listOf<String>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
        val binding = ItemDetailsAdapterBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ImagesViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        val items = imagesList[position]
        with(holder.binding) {
            with(items) {
                Glide.with(ivViewPagerItem.context)
                    .load(this)
                    .apply(
                        RequestOptions()
                            .placeholder(com.malushkoaa.core.R.drawable.loading_animation)
                            .error(com.malushkoaa.core.R.drawable.ic_broken_image)
                    )
                    .into(ivViewPagerItem)
            }
        }
    }
    
    override fun getItemCount(): Int {
        return imagesList.size
    }
    
}