package com.naufalprakoso.superheroapp.di

import com.naufalprakoso.superheroapp.database.AppDatabase
import com.naufalprakoso.superheroapp.database.dao.HeroDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
class DaoModule {
    @Provides
    internal fun provideHeroDao(appDatabase: AppDatabase): HeroDao {
        return appDatabase.heroDao()
    }
}