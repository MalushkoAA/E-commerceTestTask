package com.malushkoaa.feature_my_cart.di

import androidx.lifecycle.ViewModel
import com.malushkoaa.core.di.ViewModelKey
import com.malushkoaa.feature_my_cart.presentation.viewmodels.CartViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface CartViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(CartViewModel::class)
    fun bindCartViewModel(viewModel: CartViewModel): ViewModel
}