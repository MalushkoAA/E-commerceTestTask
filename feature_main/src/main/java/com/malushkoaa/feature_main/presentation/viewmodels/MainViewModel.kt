package com.malushkoaa.feature_main.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.malushkoaa.feature_main.domain.usecases.GetCartItemsCountUseCase
import com.malushkoaa.feature_main.domain.usecases.GetCategoriesListUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getCategoriesList: GetCategoriesListUseCase,
    private val getCartItemsCountUseCase: GetCartItemsCountUseCase
) : ViewModel() {
    
    val categoriesList = getCategoriesList()
    
    private val _cartItemsCount = MutableLiveData<Int>()
    val cartItemsCount: LiveData<Int>
        get() = _cartItemsCount
    
    init {
        viewModelScope.launch {
            try {
                _cartItemsCount.value = getCartItemsCountUseCase()
            } catch (e: Exception) {
            }
        }
    }
    
    
}