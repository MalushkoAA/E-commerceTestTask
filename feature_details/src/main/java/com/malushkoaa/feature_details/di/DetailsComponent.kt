package com.malushkoaa.feature_details.di

import com.malushkoaa.core.di.CoreComponent
import com.malushkoaa.core.di.FeatureScope
import com.malushkoaa.feature_details.presentation.screens.DetailsFragment
import dagger.Component

@FeatureScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [
        DetailsDataModule::class,
        DetailsViewModelModule::class
    ]
)
interface DetailsComponent {
    fun inject(detailsFragment: DetailsFragment)
}