package com.malushkoaa.feature_my_cart.di

import com.malushkoaa.core.di.CoreComponent
import com.malushkoaa.core.di.FeatureScope
import com.malushkoaa.feature_my_cart.MyCartFragment
import dagger.Component

@FeatureScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [
        CartDataModule::class,
        MyCartViewModelModule::class
    ]
)
interface CartComponent {
    fun inject(myCartFragment:MyCartFragment)
}