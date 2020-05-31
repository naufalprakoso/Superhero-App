package com.naufalprakoso.superheroapp

import android.app.Application
import com.naufalprakoso.superheroapp.di.AppModule
import com.naufalprakoso.superheroapp.di.ApplicationComponent
import com.naufalprakoso.superheroapp.di.DaggerApplicationComponent

class SuperheroApplication : Application() {
    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = getApplicationComponent()
        applicationComponent.inject(this)
    }

    fun getApplicationComponent(): ApplicationComponent {
        return DaggerApplicationComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}