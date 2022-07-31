package com.malushkoaa.feature_details.domain.entities

data class DetailsResponse(
    val cpu: String?,
    val camera: String?,
    val capacity: List<ItemCapacity>?,
    val color: List<ItemColors>?,
    val id: String?,
    val images: List<String>?,
    var isFavorites: Boolean?,
    val price: Int?,
    val rating: Double?,
    val sd: String?,
    val ssd: String?,
    val title: String?
)