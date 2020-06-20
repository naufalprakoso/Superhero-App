package com.naufalprakoso.superheroapp.di

import com.naufalprakoso.superheroapp.database.dao.HeroDao
import com.naufalprakoso.superheroapp.hero.repo.HeroRepository
import com.naufalprakoso.superheroapp.hero.repo.HeroRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.CoroutineScope

@InstallIn(ApplicationComponent::class)
@Module
class RepositoryModule {
    @Provides
    fun provideHeroRepository(
        heroDao: HeroDao,
        ioScope: CoroutineScope
    ): HeroRepository {
        return HeroRepositoryImpl(
            heroDao,
            ioScope
        )
    }
}