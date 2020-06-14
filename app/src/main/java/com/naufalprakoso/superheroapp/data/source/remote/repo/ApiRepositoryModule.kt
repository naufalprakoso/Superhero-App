package com.naufalprakoso.superheroapp.data.source.remote.repo

import com.naufalprakoso.superheroapp.api.ServiceBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
class ApiRepositoryModule {

    @Provides
    fun provideHeroApiRepository(serviceBuilder: ServiceBuilder): HeroApiRepository {
        return HeroApiRepositoryImpl(serviceBuilder)
    }

}