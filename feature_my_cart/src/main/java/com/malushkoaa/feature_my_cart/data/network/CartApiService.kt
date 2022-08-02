package com.malushkoaa.feature_my_cart.data.network

import com.malushkoaa.feature_my_cart.data.network.models.CartResponseDto
import retrofit2.http.GET

interface CartApiService {
    @GET("53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    suspend fun getCartData():CartResponseDto
}