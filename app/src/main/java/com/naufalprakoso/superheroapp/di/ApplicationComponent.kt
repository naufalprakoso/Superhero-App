package com.naufalprakoso.superheroapp.di

import com.naufalprakoso.superheroapp.SuperheroApplication
import com.naufalprakoso.superheroapp.data.source.local.db.DaoModule
import com.naufalprakoso.superheroapp.data.source.local.db.RoomModule
import com.naufalprakoso.superheroapp.data.source.local.repo.RepositoryModule
import com.naufalprakoso.superheroapp.data.source.usecase.UseCaseModule
import com.naufalprakoso.superheroapp.ui.antihero.AntiHeroFragment
import com.naufalprakoso.superheroapp.ui.detail.HeroDetailActivity
import com.naufalprakoso.superheroapp.ui.hero.HeroFragment
import com.naufalprakoso.superheroapp.ui.villain.VillainFragment
import com.naufalprakoso.superheroapp.viewmodel.ViewModelModule
import dagger.Component

@AppScope
@Component(modules = [
    AppModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    DaoModule::class,
    RoomModule::class,
    ViewModelModule::class
])
interface ApplicationComponent {
    fun inject(superheroApplication: SuperheroApplication)

    fun inject(antiHeroFragment: AntiHeroFragment)
    fun inject(villainFragment: VillainFragment)
    fun inject(heroFragment: HeroFragment)

    fun inject(heroDetailActivity: HeroDetailActivity)
}