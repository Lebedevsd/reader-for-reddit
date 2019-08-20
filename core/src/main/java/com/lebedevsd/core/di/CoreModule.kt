package com.lebedevsd.core.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class CoreModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder().build()
}