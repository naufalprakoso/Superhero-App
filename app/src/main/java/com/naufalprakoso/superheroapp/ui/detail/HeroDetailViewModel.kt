package com.naufalprakoso.superheroapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.naufalprakoso.superheroapp.data.source.local.relation.Superhero
import com.naufalprakoso.superheroapp.data.source.usecase.HeroUseCase
import com.naufalprakoso.superheroapp.vo.Resource
import javax.inject.Inject

class HeroDetailViewModel @Inject constructor(
    private val heroUseCase: HeroUseCase
) : ViewModel() {
    fun getHeroDetail(heroId: Long = 0): LiveData<Resource<Superhero>>? =
        heroUseCase.getHeroById(heroId)
}