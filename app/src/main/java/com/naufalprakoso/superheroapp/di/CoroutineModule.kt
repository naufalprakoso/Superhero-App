package com.naufalprakoso.superheroapp.di

import com.naufalprakoso.superheroapp.util.ContextProviders
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class CoroutineModule {
    @Singleton
    @Provides
    fun provideContextProviders() = ContextProviders()

    @Singleton
    @Provides
    fun provideCoroutineScope() = CoroutineScope(Dispatchers.IO)
}