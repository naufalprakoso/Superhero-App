package com.naufalprakoso.superheroapp.ui.hero

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.naufalprakoso.superheroapp.database.relation.Superhero
import com.naufalprakoso.superheroapp.hero.usecase.HeroUseCase
import com.naufalprakoso.superheroapp.vo.Resource

class HeroViewModel @ViewModelInject constructor(
    private val heroUseCase: HeroUseCase
) : ViewModel() {

    fun getHeroes(): LiveData<Resource<List<Superhero>>>? {
        return heroUseCase.getHeroes()
    }
}