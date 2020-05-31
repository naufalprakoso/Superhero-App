package com.naufalprakoso.superheroapp.api

import com.naufalprakoso.superheroapp.api.ServiceBuilder.retrofitBuilder
import com.naufalprakoso.superheroapp.di.DataScope
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    @DataScope
    fun provideSuperheroService(): SuperheroService {
        return retrofitBuilder.build().create(SuperheroService::class.java)
    }
}