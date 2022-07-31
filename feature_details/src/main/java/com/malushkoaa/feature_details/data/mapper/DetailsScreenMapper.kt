package com.malushkoaa.feature_details.data.mapper

import com.malushkoaa.feature_details.data.network.models.DetailsResponseModel
import com.malushkoaa.feature_details.domain.entities.DetailsResponse
import com.malushkoaa.feature_details.domain.entities.ItemCapacity
import com.malushkoaa.feature_details.domain.entities.ItemColors
import javax.inject.Inject

class DetailsScreenMapper @Inject constructor() {
    
    fun mapDtoToEntity(
        dto: DetailsResponseModel,
        color: List<ItemColors>?,
        capacity: List<ItemCapacity>?
    ) = DetailsResponse(
        cpu = dto.cpu,
        camera = dto.camera,
        capacity = capacity,
        color = color,
        id = dto.id,
        images = dto.images,
        isFavorites = dto.isFavorites,
        price = dto.price,
        rating = dto.rating,
        sd = dto.sd,
        ssd = dto.ssd,
        title = dto.title
    )
    
    fun toEntityColors(dto: String) = ItemColors(
        color = dto,
        isSelected = false
    )
    
    fun toEntityCapacity(dto: String) = ItemCapacity(
        capacity = dto,
        isSelected = false
    )
    
}