package com.malushkoaa.core.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class
    ]
)
interface CoreComponent {
    fun retrofit(): Retrofit
    
    @Component.Factory
    interface Factory {
        
        fun create(
            @BindsInstance application: Application
        ): CoreComponent
        
    }
}