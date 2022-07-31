package com.malushkoaa.feature_main.data.network.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class BestSellerDto(
    @Json(name = "discount_price") val discountPrice: Int? = null,
    @Json(name = "id") val id: Int? = null,
    @Json(name = "is_favorites") val isFavorites: Boolean? = null,
    @Json(name = "picture") val picture: String? = null,
    @Json(name = "price_without_discount") val priceWithoutDiscount: Int? = null,
    @Json(name = "title") val title: String? = null
) : Parcelable