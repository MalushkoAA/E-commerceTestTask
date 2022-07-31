package com.malushkoaa.feature_main.data.network.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class CartItemDto(
    @Json(name = "id") val id: Int? = null,
    @Json(name = "images") val images: String? = null,
    @Json(name = "price") val price: Int? = null,
    @Json(name = "title") val title: String? = null
) : Parcelable