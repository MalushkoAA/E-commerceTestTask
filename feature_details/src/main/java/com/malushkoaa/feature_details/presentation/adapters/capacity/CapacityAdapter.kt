package com.malushkoaa.feature_details.presentation.adapters.capacity

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.malushkoaa.feature_details.databinding.ItemSelectCapacityBinding
import com.malushkoaa.feature_details.domain.entities.ItemCapacity

class CapacityAdapter(private val context: Context) :
    RecyclerView.Adapter<CapacityViewHolder>() {
    
    private var checkedPosition = 0
    
    var capacitiesList = listOf<ItemCapacity>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CapacityViewHolder {
        val binding = ItemSelectCapacityBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return CapacityViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder: CapacityViewHolder, position: Int) {
        val item = capacitiesList[position]
        with(holder.binding) {
            with(item) {
                if (checkedPosition == -1) {
                    ivCapacitySelect.setColorFilter(
                        ContextCompat.getColor(
                            context,
                            com.malushkoaa.core.R.color.white
                        )
                    )
                    tvCapacityValue.setTextColor(com.malushkoaa.core.R.color.grey)
                    isSelected = false
                } else {
                    if (checkedPosition == position) {
                        ivCapacitySelect.setColorFilter(
                            ContextCompat.getColor(
                                context,
                                com.malushkoaa.core.R.color.primary
                            )
                        )
                        tvCapacityValue.setTextColor(
                            ContextCompat.getColor(
                                context,
                                com.malushkoaa.core.R.color.white
                            )
                        )
                        isSelected = true
                    } else {
                        ivCapacitySelect.setColorFilter(
                            ContextCompat.getColor(
                                context,
                                com.malushkoaa.core.R.color.white
                            )
                        )
                        tvCapacityValue.setTextColor(com.malushkoaa.core.R.color.grey)
                        isSelected = false
                    }
                }
                tvCapacityValue.text = "$capacity GB"
                root.setOnClickListener {
                    ivCapacitySelect.setColorFilter(
                        ContextCompat.getColor(
                            context,
                            com.malushkoaa.core.R.color.primary
                        )
                    )
                    tvCapacityValue.setTextColor(
                        ContextCompat.getColor(
                            context,
                            com.malushkoaa.core.R.color.white
                        )
                    )
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
        return capacitiesList.size
    }
    
}