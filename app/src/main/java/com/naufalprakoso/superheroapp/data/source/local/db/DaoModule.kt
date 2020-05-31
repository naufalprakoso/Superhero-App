package com.naufalprakoso.superheroapp.data.source.local.db

import com.naufalprakoso.superheroapp.di.AppScope
import dagger.Module
import dagger.Provides

@Module
class DaoModule {
    @Provides
    @AppScope
    internal fun provideHeroDao(appDatabase: AppDatabase): HeroDao {
        return appDatabase.heroDao()
    }
}