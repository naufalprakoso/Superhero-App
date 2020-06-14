package com.naufalprakoso.superheroapp.ui.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.naufalprakoso.superheroapp.data.source.local.relation.Superhero
import com.naufalprakoso.superheroapp.data.source.usecase.HeroUseCase
import com.naufalprakoso.superheroapp.vo.Resource

class HeroDetailViewModel @ViewModelInject constructor(
    private val heroUseCase: HeroUseCase
) : ViewModel() {
    fun getHeroDetail(heroId: Long = 0): LiveData<Resource<Superhero>>? =
        heroUseCase.getHeroById(heroId)
}