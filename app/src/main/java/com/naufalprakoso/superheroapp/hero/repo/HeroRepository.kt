package com.naufalprakoso.superheroapp.hero.repo

import androidx.lifecycle.LiveData
import com.naufalprakoso.superheroapp.database.relation.Superhero
import com.naufalprakoso.superheroapp.network.response.HeroResponse

interface HeroRepository {
    fun getHeroes(): LiveData<List<Superhero>>
    fun getAntiHeroes(): LiveData<List<Superhero>>
    fun getVillains(): LiveData<List<Superhero>>
    fun getById(id: Long): LiveData<Superhero>

    fun insertOrUpdate(data: List<HeroResponse>)
}