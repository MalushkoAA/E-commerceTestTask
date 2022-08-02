package com.malushkoaa.feature_my_cart.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.malushkoaa.feature_my_cart.domain.usecases.GetCartDataUseCase
import com.malushkoaa.feature_my_cart.presentation.CartDataState
import kotlinx.coroutines.launch
import javax.inject.Inject

class CartViewModel @Inject constructor(
    private val getCartDataUseCase: GetCartDataUseCase
) : ViewModel() {
    
    private val _cartData = MutableLiveData<CartDataState>()
    val cartData: LiveData<CartDataState>
        get() = _cartData
    
    fun getCartResponse(){
        viewModelScope.launch {
            _cartData.value=CartDataState.Loading
            try {
                _cartData.value=CartDataState.SuccessResponse(getCartDataUseCase())
            }catch (e:Exception){
                _cartData.value=CartDataState.Error
            }
        }
    }
    
    
}