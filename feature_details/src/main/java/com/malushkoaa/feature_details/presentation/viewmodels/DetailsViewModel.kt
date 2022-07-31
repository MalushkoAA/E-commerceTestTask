package com.malushkoaa.feature_details.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.malushkoaa.feature_details.domain.entities.DetailsResponse
import com.malushkoaa.feature_details.domain.usecases.GetProductDetailsUseCase
import com.malushkoaa.feature_details.presentation.ProductDetailsState
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsViewModel @Inject constructor(
    private val getProductDetailsUseCase: GetProductDetailsUseCase
) : ViewModel() {
    
    private val _productDetails = MutableLiveData<ProductDetailsState>()
    val productDetails: LiveData<ProductDetailsState>
        get() = _productDetails
    
    fun getProductData() {
        viewModelScope.launch {
            _productDetails.value = ProductDetailsState.Progress
            try {
                _productDetails.value =
                    ProductDetailsState.ProductResult(getProductDetailsUseCase())
            } catch (e: Exception) {
                _productDetails.value = ProductDetailsState.Error
                Log.e("Exception!!!", e.toString())
            }
        }
    }
    
    fun toFavoritesClick(product: DetailsResponse) {
        product.isFavorites = product.isFavorites != true
    }
    
}