package com.malushkoaa.feature_main.di

import com.malushkoaa.core.di.FeatureScope
import com.malushkoaa.feature_main.data.MainScreenRepoImpl
import com.malushkoaa.feature_main.data.network.MainApiService
import com.malushkoaa.feature_main.domain.repo.MainScreenRepo
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
interface DataModule {
    
    @Binds
    @FeatureScope
    fun bindMainScreenRepo(impl: MainScreenRepoImpl): MainScreenRepo
    
    companion object {
        @Provides
        @FeatureScope
        fun provideMainApiService(retrofit: Retrofit): MainApiService {
            return retrofit.create(MainApiService::class.java)
        }
    }
}