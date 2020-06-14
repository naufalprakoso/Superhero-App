package com.naufalprakoso.superheroapp.data.source.local.repo

import com.naufalprakoso.superheroapp.data.source.local.db.HeroDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
class RepositoryModule {
    @Provides
    fun provideHeroRepository(heroDao: HeroDao): HeroRepository {
        return HeroRepositoryImpl(heroDao)
    }
}