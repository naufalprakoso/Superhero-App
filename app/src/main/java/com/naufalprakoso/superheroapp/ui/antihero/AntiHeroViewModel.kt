package com.naufalprakoso.superheroapp.ui.antihero

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.naufalprakoso.superheroapp.database.relation.Superhero
import com.naufalprakoso.superheroapp.hero.usecase.HeroUseCase
import com.naufalprakoso.superheroapp.vo.Resource

class AntiHeroViewModel @ViewModelInject constructor(
    private val heroUseCase: HeroUseCase
) : ViewModel() {

    fun getAntiHeroes(): LiveData<Resource<List<Superhero>>>? {
        return heroUseCase.getAntiHeroes()
    }
}