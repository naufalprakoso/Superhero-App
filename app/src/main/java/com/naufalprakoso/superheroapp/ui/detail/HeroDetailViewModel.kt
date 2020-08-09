package com.naufalprakoso.superheroapp.ui.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.naufalprakoso.superheroapp.database.relation.Superhero
import com.naufalprakoso.superheroapp.hero.repo.HeroRepository

class HeroDetailViewModel @ViewModelInject constructor(
    private val heroRepository: HeroRepository
) : ViewModel() {

    fun getHeroDetail(heroId: Long = 0): LiveData<Superhero>? {
        return heroRepository.getById(heroId)
    }
}