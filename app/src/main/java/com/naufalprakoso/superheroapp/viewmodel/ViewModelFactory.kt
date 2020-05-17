package com.naufalprakoso.superheroapp.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModel
import com.naufalprakoso.superheroapp.data.source.usecase.HeroUseCase
import com.naufalprakoso.superheroapp.di.Injection
import com.naufalprakoso.superheroapp.ui.antihero.AntiHeroViewModel
import com.naufalprakoso.superheroapp.ui.hero.HeroViewModel
import com.naufalprakoso.superheroapp.ui.villain.VillainViewModel

class ViewModelFactory(
    private var heroUseCase: HeroUseCase? = null
) : ViewModelProvider.NewInstanceFactory() {

    private var id: String = ""

    constructor(
        heroUseCase: HeroUseCase? = null,
        id: String = ""
    ) : this(heroUseCase) {
        this.id = id
    }

    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application): ViewModelFactory? {
            if (INSTANCE == null) {
                synchronized(ViewModelFactory::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = ViewModelFactory(
                            Injection.provideHeroUseCase(application)
                        )
                    }
                }
            }

            return INSTANCE
        }
    }

    @SuppressWarnings("unchecked")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HeroViewModel::class.java) -> HeroViewModel(heroUseCase) as T
            modelClass.isAssignableFrom(AntiHeroViewModel::class.java) -> AntiHeroViewModel(heroUseCase) as T
            modelClass.isAssignableFrom(VillainViewModel::class.java) -> VillainViewModel(heroUseCase) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}