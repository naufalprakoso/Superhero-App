package com.naufalprakoso.superheroapp.di

import android.annotation.SuppressLint
import android.app.Application
import com.naufalprakoso.superheroapp.data.source.local.db.AppDatabase
import com.naufalprakoso.superheroapp.data.source.local.repo.HeroRepository
import com.naufalprakoso.superheroapp.data.source.usecase.HeroUseCase
import com.naufalprakoso.superheroapp.data.source.usecase.HeroUseCaseImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class Injection {
    companion object {
        @SuppressLint("VisibleForTests")
        fun provideHeroUseCase(application: Application): HeroUseCase? {
            val appDatabase = AppDatabase.getInstance(application) ?: return null

            val ioScope = CoroutineScope(Dispatchers.IO)
            val heroDao = appDatabase.heroDao()
            val heroRepository = HeroRepository.getInstance(heroDao)

            return HeroUseCaseImpl.getInstance(heroRepository, ioScope)
        }
    }
}