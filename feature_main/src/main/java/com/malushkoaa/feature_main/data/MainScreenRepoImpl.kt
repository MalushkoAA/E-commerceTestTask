package com.malushkoaa.feature_main.data

import com.malushkoaa.feature_main.data.localdatasource.MainScreenDataSource
import com.malushkoaa.feature_main.data.mapper.MainScreenMapper
import com.malushkoaa.feature_main.data.network.MainApiService
import com.malushkoaa.feature_main.domain.entities.Categories
import com.malushkoaa.feature_main.domain.entities.PhonesResponseEntities
import com.malushkoaa.feature_main.domain.repo.MainScreenRepo
import javax.inject.Inject

class MainScreenRepoImpl @Inject constructor(
    
    private val mapper: MainScreenMapper,
    private val mainScreenDataSource: MainScreenDataSource,
    private val apiService: MainApiService
) : MainScreenRepo {
    
    override suspend fun loadPhonesData(): PhonesResponseEntities {
        
        val response = apiService.getMainResponse()
        
        val hotSales = response.hotSales.map {
            mapper.madDtoToEntity(it)
        }
        val bestSellers = response.bestSellers.map {
            mapper.mapDtoToEntity(it)
        }
        
        return PhonesResponseEntities(
            bestSeller = bestSellers,
            hotSale = hotSales
        )
    }
    
    override suspend fun getCartItemsCount(): Int {
        return apiService.getCartResponse().cartItems.size
    }
    
    override fun getCategoriesList(): List<Categories> {
        return mainScreenDataSource.categoriesList.map {
            mapper.mapDbModelToEntity(it)
        }
    }
    
}