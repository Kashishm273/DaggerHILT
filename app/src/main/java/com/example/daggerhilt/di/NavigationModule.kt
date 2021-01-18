package com.example.daggerhilt.di

import com.example.daggerhilt.navigator.AppNavigator
import com.example.daggerhilt.navigator.AppNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
abstract class NavigationModule {

    @Binds
    abstract fun bindNavigator(appNavigatorImpl: AppNavigatorImpl): AppNavigator
}
