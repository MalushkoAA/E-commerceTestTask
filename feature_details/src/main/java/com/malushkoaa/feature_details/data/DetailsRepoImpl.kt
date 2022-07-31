package com.malushkoaa.feature_details.data

import com.malushkoaa.feature_details.data.mapper.DetailsScreenMapper
import com.malushkoaa.feature_details.data.network.DetailsApiService
import com.malushkoaa.feature_details.domain.entities.DetailsResponse
import com.malushkoaa.feature_details.domain.repo.DetailsRepo
import javax.inject.Inject

class DetailsRepoImpl @Inject constructor(
    private val mapper: DetailsScreenMapper,
    private val apiService: DetailsApiService
) : DetailsRepo {
    
    override suspend fun getProductDetails(): DetailsResponse {
        
        val response = apiService.getDetails()
        
        val colors = response.color?.map {
            mapper.toEntityColors(it)
        }
        
        val capacity = response.capacity?.map {
            mapper.toEntityCapacity(it)
        }
        
        return mapper.mapDtoToEntity(response, colors, capacity)
    }
    
}