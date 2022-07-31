package com.malushkoaa.feature_main.domain.entities

data class BestSeller(
    val discountPrice: String?,
    val id: Int?,
    var isFavorites: Boolean?,
    val picture: String?,
    val priceWithoutDiscount: String?,
    val title: String?
)
