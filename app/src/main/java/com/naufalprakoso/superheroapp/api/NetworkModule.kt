package com.naufalprakoso.superheroapp.api

import com.naufalprakoso.superheroapp.api.ServiceBuilder.retrofitBuilder
import com.naufalprakoso.superheroapp.di.DataScope
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
class NetworkModule {

    @Provides
    @DataScope
    fun provideSuperheroService(): SuperheroService {
        return retrofitBuilder.build().create(SuperheroService::class.java)
    }
}