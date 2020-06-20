package com.naufalprakoso.superheroapp.di

import com.naufalprakoso.superheroapp.api.ServiceBuilder
import com.naufalprakoso.superheroapp.hero.apirepo.HeroApiRepository
import com.naufalprakoso.superheroapp.hero.apirepo.HeroApiRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
class ApiRepositoryModule {

    @Provides
    fun provideHeroApiRepository(serviceBuilder: ServiceBuilder): HeroApiRepository {
        return HeroApiRepositoryImpl(
            serviceBuilder
        )
    }
}