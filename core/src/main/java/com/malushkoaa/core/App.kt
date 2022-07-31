package com.malushkoaa.core

import android.app.Application
import com.malushkoaa.core.di.DaggerCoreComponent

class App : Application() {
    val coreComponent by lazy {
        DaggerCoreComponent.factory().create(this)
    }
}