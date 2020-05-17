package com.naufalprakoso.superheroapp.ui.villain

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.naufalprakoso.superheroapp.data.source.local.relation.Superhero
import com.naufalprakoso.superheroapp.data.source.usecase.HeroUseCase
import com.naufalprakoso.superheroapp.vo.Resource

class VillainViewModel(
    private val heroUseCase: HeroUseCase? = null
) : ViewModel() {
    fun getVillains(): LiveData<Resource<PagedList<Superhero>>>? = heroUseCase?.getVillains()
}