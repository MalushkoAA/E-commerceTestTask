package com.malushkoaa.feature_my_cart.domain.repo

import com.malushkoaa.feature_my_cart.domain.entities.CartResponse

interface CartRepo {
    suspend fun getCartData(): CartResponse
}