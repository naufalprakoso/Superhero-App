package com.naufalprakoso.superheroapp.ui.villain

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.naufalprakoso.superheroapp.database.relation.Superhero
import com.naufalprakoso.superheroapp.hero.usecase.HeroUseCase
import com.naufalprakoso.superheroapp.vo.Resource

class VillainViewModel @ViewModelInject constructor(
    private val heroUseCase: HeroUseCase
) : ViewModel() {
    fun getVillains(): LiveData<Resource<PagedList<Superhero>>>? = heroUseCase.getVillains()
}