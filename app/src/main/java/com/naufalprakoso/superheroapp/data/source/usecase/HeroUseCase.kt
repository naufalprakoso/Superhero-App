package com.naufalprakoso.superheroapp.data.source.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.naufalprakoso.superheroapp.data.source.local.relation.Superhero
import com.naufalprakoso.superheroapp.vo.Resource

interface HeroUseCase {
    fun getHeroes(): LiveData<Resource<PagedList<Superhero>>>
    fun getAntiHeroes(): LiveData<Resource<PagedList<Superhero>>>
    fun getVillains(): LiveData<Resource<PagedList<Superhero>>>
    fun getHeroById(id: Long): LiveData<Resource<Superhero>>
}