package com.malushkoaa.feature_main.di

import androidx.lifecycle.ViewModel
import com.malushkoaa.core.di.ViewModelKey
import com.malushkoaa.feature_main.presentation.viewmodels.MainViewModel
import com.malushkoaa.feature_main.presentation.viewmodels.PhonesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel
    
    @Binds
    @IntoMap
    @ViewModelKey(PhonesViewModel::class)
    fun bindPhonesViewModel(viewModel: PhonesViewModel): ViewModel
}