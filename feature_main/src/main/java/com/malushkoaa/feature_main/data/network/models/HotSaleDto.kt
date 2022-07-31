package com.malushkoaa.feature_main.data.network.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class HotSaleDto(
    @Json(name = "id") val id: Int? = null,
    @Json(name = "is_buy") val isBuy: Boolean? = null,
    @Json(name = "is_new") val isNew: Boolean? = null,
    @Json(name = "picture") val picture: String? = null,
    @Json(name = "subtitle") val subtitle: String? = null,
    @Json(name = "title") val title: String? = null
) : Parcelable