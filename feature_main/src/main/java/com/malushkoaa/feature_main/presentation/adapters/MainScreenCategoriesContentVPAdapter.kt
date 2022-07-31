package com.malushkoaa.feature_main.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.malushkoaa.feature_main.domain.entities.Categories
import com.malushkoaa.feature_main.presentation.screens.MainFragment
import com.malushkoaa.feature_main.presentation.screens.categoriescontent.EmptyFragment
import com.malushkoaa.feature_main.presentation.screens.categoriescontent.PhonesFragment


class MainScreenCategoriesContentVPAdapter(
    private val categoriesList: List<Categories>,
    fragment: MainFragment
) : FragmentStateAdapter(fragment) {
    
    override fun getItemCount(): Int {
        return categoriesList.size
    }
    
    override fun createFragment(position: Int): Fragment {
        return when (categoriesList[position].id) {
            0 -> PhonesFragment()
            else -> EmptyFragment()
        }
    }
    
}