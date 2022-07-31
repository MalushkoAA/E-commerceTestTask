package com.malushkoaa.feature_main.presentation

import com.malushkoaa.feature_main.domain.entities.PhonesResponseEntities

sealed class CategoriesResponseState {
    object Error : CategoriesResponseState()
    
    object Progress : CategoriesResponseState()
    
    class PhonesResult(val data: PhonesResponseEntities) : CategoriesResponseState()
}
