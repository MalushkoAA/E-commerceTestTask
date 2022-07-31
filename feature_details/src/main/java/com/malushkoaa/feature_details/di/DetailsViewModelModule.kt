package com.malushkoaa.feature_details.di

import androidx.lifecycle.ViewModel
import com.malushkoaa.core.di.ViewModelKey
import com.malushkoaa.feature_details.presentation.viewmodels.DetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface DetailsViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    fun bindDetailsViewModel(viewModel: DetailsViewModel):ViewModel
}