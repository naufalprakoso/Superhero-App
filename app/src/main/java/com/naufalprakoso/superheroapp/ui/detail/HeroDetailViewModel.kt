package com.naufalprakoso.superheroapp.ui.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.naufalprakoso.superheroapp.database.relation.Superhero
import com.naufalprakoso.superheroapp.hero.usecase.HeroUseCase
import com.naufalprakoso.superheroapp.vo.Resource

class HeroDetailViewModel @ViewModelInject constructor(
    private val heroUseCase: HeroUseCase
) : ViewModel() {

    fun getHeroDetail(heroId: Long = 0): LiveData<Resource<Superhero>>? {
        return heroUseCase.getHeroById(heroId)
    }
}