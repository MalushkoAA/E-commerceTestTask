package com.malushkoaa.feature_my_cart.di

import com.malushkoaa.core.di.FeatureScope
import com.malushkoaa.feature_my_cart.data.CartRepoImpl
import com.malushkoaa.feature_my_cart.data.network.MyCartApiService
import com.malushkoaa.feature_my_cart.domain.repo.CartRepo
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
interface CartDataModule {
    
    @Binds
    @FeatureScope
    fun bindCartRepo(impl: CartRepoImpl): CartRepo
    
    companion object {
        @Provides
        @FeatureScope
        fun provideMyCartApiService(retrofit: Retrofit): MyCartApiService {
            return retrofit.create(MyCartApiService::class.java)
        }
    }
}