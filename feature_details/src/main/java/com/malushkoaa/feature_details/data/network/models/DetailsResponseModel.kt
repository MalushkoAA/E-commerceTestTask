package com.malushkoaa.feature_details.data.network.models


import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailsResponseModel(
    @Json(name = "CPU") val cpu: String?,
    @Json(name = "camera") val camera: String?,
    @Json(name = "capacity") val capacity: List<String>?,
    @Json(name = "color") val color: List<String>?,
    @Json(name = "id") val id: String?,
    @Json(name = "images") val images: List<String>?,
    @Json(name = "isFavorites") val isFavorites: Boolean?,
    @Json(name = "price") val price: Int?,
    @Json(name = "rating") val rating: Double?,
    @Json(name = "sd") val sd: String?,
    @Json(name = "ssd") val ssd: String?,
    @Json(name = "title") val title: String?
) : Parcelable