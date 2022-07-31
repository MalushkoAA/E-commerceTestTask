package com.malushkoaa.feature_details.presentation

import com.malushkoaa.feature_details.domain.entities.DetailsResponse

sealed class ProductDetailsState{
    object Error : ProductDetailsState()
    
    object Progress : ProductDetailsState()
    
    class ProductResult(val data: DetailsResponse) : ProductDetailsState()
}
