package com.malushkoaa.feature_my_cart.data

import com.malushkoaa.feature_my_cart.data.mapper.CartScreenMapper
import com.malushkoaa.feature_my_cart.data.network.CartApiService
import com.malushkoaa.feature_my_cart.domain.entities.CartResponse
import com.malushkoaa.feature_my_cart.domain.repo.CartRepo
import javax.inject.Inject

class CartRepoImpl @Inject constructor(
    private val mapper: CartScreenMapper,
    private val apiService: CartApiService
) : CartRepo {
    
    override suspend fun getCartData(): CartResponse {
        val response= apiService.getCartData()
        
        val itemBasketList=response.basketDto?.map {
            mapper.toItemBasketEntity(it)
        }
        
        return mapper.toCartEntity(response, itemBasketList)
    }
    
}