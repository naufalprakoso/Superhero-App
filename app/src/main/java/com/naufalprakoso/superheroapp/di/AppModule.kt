package com.naufalprakoso.superheroapp.di

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val context: Context) {
    @Provides
    @AppScope
    internal fun provideContext(): Context {
        return context
    }
}