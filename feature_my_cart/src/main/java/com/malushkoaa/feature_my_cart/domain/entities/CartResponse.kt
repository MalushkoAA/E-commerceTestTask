package com.malushkoaa.feature_my_cart.domain.entities

data class CartResponse(
    val itemBasket: List<ItemBasket>?,
    val delivery: String?,
    val id: String?,
    val total: Int?
)
