package com.example.readerforreddit.di

import com.example.loginfeature.ui.LoginActivity
import com.example.readerforreddit.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun loginActivity(): LoginActivity
}