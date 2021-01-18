package com.example.daggerhilt.di

import com.example.daggerhilt.data.LoggerDataSource
import com.example.daggerhilt.data.LoggerDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
abstract class LoggingModule {

    @Binds
    @Singleton
    abstract fun bindDatabaseLogger(loggerDataSourceImpl: LoggerDataSourceImpl): LoggerDataSource
}
