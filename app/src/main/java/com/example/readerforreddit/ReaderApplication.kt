package com.example.readerforreddit

import com.example.readerforreddit.di.DaggerAppComponent
import com.lebedevsd.core.di.CoreComponent
import com.lebedevsd.core.di.CoreComponentProvider
import com.lebedevsd.core.di.DaggerCoreComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class ReaderApplication: DaggerApplication(), CoreComponentProvider {

    private lateinit var coreComponent: CoreComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent
            .builder()
            .application(this)
            .coreComponent(provideCoreComponent())
            .build()
    }

    override fun provideCoreComponent(): CoreComponent {
        if (!this::coreComponent.isInitialized) {
            coreComponent = DaggerCoreComponent
                .builder()
                .build()
        }
        return coreComponent
    }
}