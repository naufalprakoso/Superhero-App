package com.naufalprakoso.superheroapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.naufalprakoso.superheroapp.data.source.local.relation.Superhero
import com.naufalprakoso.superheroapp.data.source.usecase.HeroUseCase
import com.naufalprakoso.superheroapp.vo.Resource

class HeroDetailViewModel(
    var heroId: Long = 0,
    private val heroUseCase: HeroUseCase? = null
) : ViewModel() {
    fun getHeroDetail(): LiveData<Resource<Superhero>>? =
        heroUseCase?.getHeroById(heroId)
}