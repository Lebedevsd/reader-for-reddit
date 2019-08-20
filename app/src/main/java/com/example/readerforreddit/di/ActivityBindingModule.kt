package com.example.readerforreddit.di

import com.example.readerforreddit.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}