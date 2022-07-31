package com.malushkoaa.feature_details.domain.repo

import com.malushkoaa.feature_details.domain.entities.DetailsResponse

interface DetailsRepo {
    suspend fun getProductDetails(): DetailsResponse
    
}