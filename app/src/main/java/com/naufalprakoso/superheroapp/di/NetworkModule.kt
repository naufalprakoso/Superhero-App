package com.naufalprakoso.superheroapp.di

import com.naufalprakoso.superheroapp.api.ServiceBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
class NetworkModule {

    @Provides
    fun provideServiceBuilder() = ServiceBuilder()
}