package com.naufalprakoso.superheroapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.naufalprakoso.superheroapp.di.AppScope
import com.naufalprakoso.superheroapp.ui.antihero.AntiHeroViewModel
import com.naufalprakoso.superheroapp.ui.detail.HeroDetailViewModel
import com.naufalprakoso.superheroapp.ui.hero.HeroViewModel
import com.naufalprakoso.superheroapp.ui.villain.VillainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @AppScope
    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(VillainViewModel::class)
    internal abstract fun bindVillainViewModel(viewModel: VillainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HeroViewModel::class)
    internal abstract fun bindHeroViewModel(viewModel: HeroViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AntiHeroViewModel::class)
    internal abstract fun bindAntiHeroViewModel(viewModel: AntiHeroViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HeroDetailViewModel::class)
    internal abstract fun bindHeroDetailViewModel(viewModel: HeroDetailViewModel): ViewModel
}