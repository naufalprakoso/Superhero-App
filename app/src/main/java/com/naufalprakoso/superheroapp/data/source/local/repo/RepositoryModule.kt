package com.naufalprakoso.superheroapp.data.source.local.repo

import com.naufalprakoso.superheroapp.data.source.local.db.HeroDao
import com.naufalprakoso.superheroapp.di.AppScope
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @AppScope
    @Provides
    fun provideHeroRepository(heroDao: HeroDao): HeroRepository {
        return HeroRepositoryImpl(heroDao)
    }
}