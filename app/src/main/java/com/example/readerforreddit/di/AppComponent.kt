package com.example.readerforreddit.di

import android.app.Application
import com.example.readerforreddit.ReaderApplication
import com.lebedevsd.core.di.CoreComponent
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [AppModule::class,
    ActivityBindingModule::class,
    AndroidSupportInjectionModule::class],
    dependencies = [CoreComponent::class]
)
@ApplicationScope
interface AppComponent : AndroidInjector<ReaderApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun coreComponent(coreComponent: CoreComponent): Builder
        fun build(): AppComponent
    }
}