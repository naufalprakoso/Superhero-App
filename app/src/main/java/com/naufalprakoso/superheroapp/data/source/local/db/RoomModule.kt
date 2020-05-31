package com.naufalprakoso.superheroapp.data.source.local.db

import android.content.Context
import com.naufalprakoso.superheroapp.di.AppScope
import dagger.Module
import dagger.Provides

@Module
class RoomModule {
    @Provides
    @AppScope
    internal fun provideAppDatabase(context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }
}