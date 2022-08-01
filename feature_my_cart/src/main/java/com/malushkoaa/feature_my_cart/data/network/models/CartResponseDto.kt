package com.malushkoaa.feature_my_cart.data.network.models


import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class CartResponseDto(
    @Json(name = "basket")
    val basketDto: List<BasketDto>? = null,
    @Json(name = "delivery")
    val delivery: String? = null,
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "total")
    val total: Int? = null
) : Parcelable