package com.naufalprakoso.superheroapp.hero.usecase

import androidx.lifecycle.LiveData
import com.naufalprakoso.superheroapp.database.relation.Superhero
import com.naufalprakoso.superheroapp.vo.Resource

interface HeroUseCase {
    fun getHeroes(): LiveData<Resource<List<Superhero>>>
    fun getAntiHeroes(): LiveData<Resource<List<Superhero>>>
    fun getVillains(): LiveData<Resource<List<Superhero>>>
}