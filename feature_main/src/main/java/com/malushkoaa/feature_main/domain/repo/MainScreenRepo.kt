package com.malushkoaa.feature_main.domain.repo

import com.malushkoaa.feature_main.domain.entities.Categories
import com.malushkoaa.feature_main.domain.entities.PhonesResponseEntities

interface MainScreenRepo {

    suspend fun loadPhonesData(): PhonesResponseEntities

    suspend fun getCartItemsCount(): Int

    fun getCategoriesList(): List<Categories>

}