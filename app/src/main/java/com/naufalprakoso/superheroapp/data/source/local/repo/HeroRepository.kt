package com.naufalprakoso.superheroapp.data.source.local.repo

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.naufalprakoso.superheroapp.data.source.local.relation.Superhero
import com.naufalprakoso.superheroapp.data.source.remote.response.HeroResponse

interface HeroRepository {
    fun getHeroes(): DataSource.Factory<Int, Superhero>
    fun getAntiHeroes(): DataSource.Factory<Int, Superhero>
    fun getVillains(): DataSource.Factory<Int, Superhero>
    fun getById(id: Long): LiveData<Superhero>

    fun insertOrUpdate(data: List<HeroResponse>)
}