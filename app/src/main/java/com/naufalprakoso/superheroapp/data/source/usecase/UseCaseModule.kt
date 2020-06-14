package com.naufalprakoso.superheroapp.data.source.usecase

import com.naufalprakoso.superheroapp.data.source.local.repo.HeroRepository
import com.naufalprakoso.superheroapp.util.ContextProviders
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

@InstallIn(ApplicationComponent::class)
@Module
class UseCaseModule {
    private val ioScope = CoroutineScope(Dispatchers.IO)
    private val contextProviders = ContextProviders()

    @Provides
    fun provideHeroUseCase(
        heroRepository: HeroRepository
    ): HeroUseCase {
        return HeroUseCaseImpl(
            heroRepository,
            ioScope,
            contextProviders
        )
    }
}