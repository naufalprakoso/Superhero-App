package com.naufalprakoso.superheroapp.di

import com.naufalprakoso.superheroapp.hero.repo.HeroRepository
import com.naufalprakoso.superheroapp.hero.apirepo.HeroApiRepository
import com.naufalprakoso.superheroapp.hero.usecase.HeroUseCase
import com.naufalprakoso.superheroapp.hero.usecase.HeroUseCaseImpl
import com.naufalprakoso.superheroapp.util.ContextProviders
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
class UseCaseModule {
    @Provides
    @Reusable
    fun provideHeroUseCase(
        heroRepository: HeroRepository,
        heroApiRepository: HeroApiRepository,
        contextProviders: ContextProviders
    ): HeroUseCase {
        return HeroUseCaseImpl(
            heroRepository,
            heroApiRepository,
            contextProviders
        )
    }
}