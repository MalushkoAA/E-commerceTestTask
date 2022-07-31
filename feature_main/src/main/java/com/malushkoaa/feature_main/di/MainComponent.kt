package com.malushkoaa.feature_main.di

import com.malushkoaa.core.di.CoreComponent
import com.malushkoaa.core.di.FeatureScope
import com.malushkoaa.feature_main.presentation.screens.MainFragment
import com.malushkoaa.feature_main.presentation.screens.categoriescontent.PhonesFragment
import dagger.Component


@FeatureScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface MainComponent {
    fun inject(mainFragment: MainFragment)
    fun inject(phonesFragment: PhonesFragment)
}