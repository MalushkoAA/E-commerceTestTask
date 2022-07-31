package com.malushkoaa.feature_main.data.network.models

import com.squareup.moshi.Json

data class CartResponseModel(
    @Json(name = "basket") val cartItems: List<CartItemDto>,
    @Json(name = "delivery") val delivery: String,
    @Json(name = "id") val id: String,
    @Json(name = "total") val total: Int
)