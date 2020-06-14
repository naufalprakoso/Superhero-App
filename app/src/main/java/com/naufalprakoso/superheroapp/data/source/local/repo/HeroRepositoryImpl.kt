package com.naufalprakoso.superheroapp.data.source.local.repo

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.naufalprakoso.superheroapp.data.source.local.db.HeroDao
import com.naufalprakoso.superheroapp.data.source.local.entity.Hero
import com.naufalprakoso.superheroapp.data.source.local.entity.Work
import com.naufalprakoso.superheroapp.data.source.local.entity.Biography
import com.naufalprakoso.superheroapp.data.source.local.entity.Appearance
import com.naufalprakoso.superheroapp.data.source.local.entity.Image
import com.naufalprakoso.superheroapp.data.source.local.entity.Connection
import com.naufalprakoso.superheroapp.data.source.local.entity.PowerStat
import com.naufalprakoso.superheroapp.data.source.local.relation.Superhero

class HeroRepositoryImpl(private val heroDao: HeroDao) : HeroRepository {
    override fun getHeroes(): DataSource.Factory<Int, Superhero> {
        return heroDao.getHeroes()
    }

    override fun getAntiHeroes(): DataSource.Factory<Int, Superhero> {
        return heroDao.getAntiHeroes()
    }

    override fun getVillains(): DataSource.Factory<Int, Superhero> {
        return heroDao.getVillains()
    }

    override fun getById(id: Long): LiveData<Superhero> {
        return heroDao.getById(id)
    }

    override suspend fun insertSuperheroes(
        heroes: List<Hero>,
        powerStats: List<PowerStat>,
        works: List<Work>,
        biographies: List<Biography>,
        connections: List<Connection>,
        images: List<Image>,
        appearances: List<Appearance>
    ) {
        heroDao.insertSuperheroes(
            heroes, powerStats, works,
            biographies, connections, images, appearances
        )
    }
}