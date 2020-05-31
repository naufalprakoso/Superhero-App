package com.naufalprakoso.superheroapp.ui.antihero

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.naufalprakoso.superheroapp.data.source.local.relation.Superhero
import com.naufalprakoso.superheroapp.data.source.usecase.HeroUseCase
import com.naufalprakoso.superheroapp.vo.Resource
import javax.inject.Inject

class AntiHeroViewModel @Inject constructor(
    private val heroUseCase: HeroUseCase
) : ViewModel() {
    fun getAntiHeroes(): LiveData<Resource<PagedList<Superhero>>>? = heroUseCase.getAntiHeroes()
}