package com.malushkoaa.feature_details.data.network

import com.malushkoaa.feature_details.data.network.models.DetailsResponseModel
import retrofit2.http.GET

interface DetailsApiService {
    @GET("6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    suspend fun getDetails():DetailsResponseModel
}