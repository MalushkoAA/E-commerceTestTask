package com.malushkoaa.feature_my_cart.di

import androidx.lifecycle.ViewModel
import com.malushkoaa.core.di.ViewModelKey
import com.malushkoaa.feature_my_cart.presentation.viewmodels.MyCartViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface MyCartViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MyCartViewModel::class)
    fun bindMyCartViewModel(viewModel: MyCartViewModel): ViewModel
}