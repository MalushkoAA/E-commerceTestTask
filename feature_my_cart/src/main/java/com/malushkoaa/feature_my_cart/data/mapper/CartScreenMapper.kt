package com.malushkoaa.feature_my_cart.data.mapper

import com.malushkoaa.feature_my_cart.data.network.models.BasketDto
import com.malushkoaa.feature_my_cart.data.network.models.CartResponseDto
import com.malushkoaa.feature_my_cart.domain.entities.CartResponse
import com.malushkoaa.feature_my_cart.domain.entities.ItemBasket
import javax.inject.Inject

class CartScreenMapper @Inject constructor() {
    fun toCartEntity(
        dto: CartResponseDto,
        itemBasketList: List<ItemBasket>?
    ) = CartResponse(
        itemBasket = itemBasketList,
        delivery = dto.delivery,
        id = dto.id,
        total = dto.total
    )
    
    fun toItemBasketEntity(
        dto: BasketDto
    ) = ItemBasket(
        id = dto.id,
        images = dto.images,
        price = dto.price,
        title = dto.title
    )
    
}