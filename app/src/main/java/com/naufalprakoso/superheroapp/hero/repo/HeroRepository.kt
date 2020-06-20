package com.naufalprakoso.superheroapp.hero.repo

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.naufalprakoso.superheroapp.database.relation.Superhero
import com.naufalprakoso.superheroapp.network.response.HeroResponse

interface HeroRepository {
    fun getHeroes(): DataSource.Factory<Int, Superhero>
    fun getAntiHeroes(): DataSource.Factory<Int, Superhero>
    fun getVillains(): DataSource.Factory<Int, Superhero>
    fun getById(id: Long): LiveData<Superhero>

    fun insertOrUpdate(data: List<HeroResponse>)
}