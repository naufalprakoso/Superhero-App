package com.naufalprakoso.superheroapp.ui.hero

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.naufalprakoso.superheroapp.data.source.local.relation.Superhero
import com.naufalprakoso.superheroapp.data.source.usecase.HeroUseCase
import com.naufalprakoso.superheroapp.vo.Resource

class HeroViewModel(
    private val heroUseCase: HeroUseCase? = null
) : ViewModel() {
    fun getHeroes(): LiveData<Resource<PagedList<Superhero>>>? = heroUseCase?.getHeroes()
}