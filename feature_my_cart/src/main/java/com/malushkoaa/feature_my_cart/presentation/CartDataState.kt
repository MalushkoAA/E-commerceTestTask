package com.malushkoaa.feature_my_cart.presentation

import com.malushkoaa.feature_my_cart.domain.entities.CartResponse

sealed class CartDataState {
    object Error : CartDataState()
    object Loading : CartDataState()
    class SuccessResponse(val response: CartResponse) : CartDataState()
}
