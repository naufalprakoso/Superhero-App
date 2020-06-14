package com.naufalprakoso.superheroapp.ui.hero

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.naufalprakoso.superheroapp.data.source.local.relation.Superhero
import com.naufalprakoso.superheroapp.data.source.usecase.HeroUseCase
import com.naufalprakoso.superheroapp.vo.Resource

class HeroViewModel @ViewModelInject constructor(
    private val heroUseCase: HeroUseCase
) : ViewModel() {
    fun getHeroes(): LiveData<Resource<PagedList<Superhero>>>? = heroUseCase.getHeroes()
}