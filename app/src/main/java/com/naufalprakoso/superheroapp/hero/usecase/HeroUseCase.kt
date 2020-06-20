package com.naufalprakoso.superheroapp.hero.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.naufalprakoso.superheroapp.database.relation.Superhero
import com.naufalprakoso.superheroapp.vo.Resource

interface HeroUseCase {
    fun getHeroes(): LiveData<Resource<PagedList<Superhero>>>
    fun getAntiHeroes(): LiveData<Resource<PagedList<Superhero>>>
    fun getVillains(): LiveData<Resource<PagedList<Superhero>>>
    fun getHeroById(id: Long): LiveData<Resource<Superhero>>
}