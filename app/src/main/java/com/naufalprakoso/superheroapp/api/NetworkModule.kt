package com.naufalprakoso.superheroapp.api

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