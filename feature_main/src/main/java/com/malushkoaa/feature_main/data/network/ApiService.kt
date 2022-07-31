package com.malushkoaa.feature_main.data.network

import com.malushkoaa.feature_main.data.network.models.CartResponseModel
import com.malushkoaa.feature_main.data.network.models.PhonesResponseModel
import retrofit2.http.GET


interface MainApiService{
    @GET("654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getMainResponse() : PhonesResponseModel

    @GET("53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    suspend fun getCartResponse() : CartResponseModel

}