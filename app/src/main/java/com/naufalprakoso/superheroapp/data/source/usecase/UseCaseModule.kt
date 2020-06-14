package com.naufalprakoso.superheroapp.data.source.usecase

import com.naufalprakoso.superheroapp.data.source.local.repo.HeroRepository
import com.naufalprakoso.superheroapp.util.ContextProviders
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.CoroutineScope

@InstallIn(ApplicationComponent::class)
@Module
class UseCaseModule {
    @Provides
    fun provideHeroUseCase(
        heroRepository: HeroRepository,
        ioScope: CoroutineScope,
        contextProviders: ContextProviders
    ): HeroUseCase {
        return HeroUseCaseImpl(
            heroRepository,
            ioScope,
            contextProviders
        )
    }
}