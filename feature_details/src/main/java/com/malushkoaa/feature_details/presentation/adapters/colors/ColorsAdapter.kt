package com.malushkoaa.feature_details.presentation.adapters.colors

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.malushkoaa.feature_details.databinding.ItemSelectColorBinding
import com.malushkoaa.feature_details.domain.entities.ItemColors

class ColorsAdapter :
    RecyclerView.Adapter<ColorsViewHolder>() {
    
    var checkedPosition = 0
    
    var colorsList = listOf<ItemColors>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorsViewHolder {
        val binding = ItemSelectColorBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ColorsViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder: ColorsViewHolder, position: Int) {
        val item = colorsList[position]
        
        with(holder.binding) {
            with(item) {
                if (checkedPosition == -1) {
                    ivIsSelected.visibility = View.GONE
                    isSelected = false
                } else {
                    if (checkedPosition == position) {
                        ivIsSelected.visibility = View.VISIBLE
                        isSelected = true
                    } else {
                        ivIsSelected.visibility = View.GONE
                        isSelected = false
                    }
                }
                ivColorCircle.setColorFilter(Color.parseColor(item.color))
                root.setOnClickListener {
                    ivIsSelected.visibility = View.VISIBLE
                    isSelected = true
                    if (checkedPosition != position) {
                        notifyItemChanged(checkedPosition)
                        checkedPosition = position
                    }
                }
            }
        }
    }
    
    override fun getItemCount(): Int {
        return colorsList.size
    }
    
}