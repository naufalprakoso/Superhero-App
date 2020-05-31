package com.naufalprakoso.superheroapp.data.source.usecase

import com.naufalprakoso.superheroapp.api.NetworkModule
import com.naufalprakoso.superheroapp.data.source.local.repo.HeroRepository
import com.naufalprakoso.superheroapp.di.AppScope
import com.naufalprakoso.superheroapp.util.ContextProviders
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

@Module(includes = [NetworkModule::class])
class UseCaseModule {
    private val ioScope = CoroutineScope(Dispatchers.IO)
    private val contextProviders = ContextProviders()

    @AppScope
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