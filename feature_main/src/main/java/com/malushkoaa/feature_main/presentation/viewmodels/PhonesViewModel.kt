package com.malushkoaa.feature_main.presentation.viewmodels

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.malushkoaa.feature_main.domain.entities.BestSeller
import com.malushkoaa.feature_main.domain.entities.PhonesResponseEntities
import com.malushkoaa.feature_main.domain.usecases.LoadDataFromServerUseCase
import com.malushkoaa.feature_main.presentation.CategoriesResponseState
import kotlinx.coroutines.launch
import javax.inject.Inject

class PhonesViewModel @Inject constructor(
    private val loadDataFromServerUseCase: LoadDataFromServerUseCase
) : ViewModel() {
    
    private val _categoriesResponseState = MutableLiveData<CategoriesResponseState>()
    val categoriesResponseState: LiveData<CategoriesResponseState>
        get() = _categoriesResponseState
    
    fun startRequest() {
        viewModelScope.launch {
            _categoriesResponseState.value = CategoriesResponseState.Progress
            try {
                _categoriesResponseState.value =
                    CategoriesResponseState.PhonesResult(loadDataFromServerUseCase())
            } catch (e: Exception) {
                _categoriesResponseState.value = CategoriesResponseState.Error
                Log.e("Exception", e.toString())
            }
        }
    }
    
    fun onBestSellerFavoriteClick(bestSellerItem: BestSeller) {
        bestSellerItem.isFavorites = bestSellerItem.isFavorites != true
    }
}