package com.malushkoaa.feature_details.di

import com.malushkoaa.core.di.FeatureScope
import com.malushkoaa.feature_details.data.DetailsRepoImpl
import com.malushkoaa.feature_details.data.network.DetailsApiService
import com.malushkoaa.feature_details.domain.repo.DetailsRepo
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
interface DetailsDataModule {
    
    @Binds
    @FeatureScope
    fun bindDetailsRepo(impl: DetailsRepoImpl): DetailsRepo
    
    companion object {
        @Provides
        @FeatureScope
        fun provideDetailsApiService(retrofit: Retrofit): DetailsApiService {
            return retrofit.create(DetailsApiService::class.java)
        }
    }
}