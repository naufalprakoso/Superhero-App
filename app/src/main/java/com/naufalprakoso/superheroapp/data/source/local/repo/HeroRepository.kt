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

class HeroRepository(private val heroDao: HeroDao) {
    companion object {
        private var INSTANCE: HeroRepository? = null

        fun getInstance(heroDao: HeroDao): HeroRepository? {
            if (INSTANCE == null) {
                INSTANCE = HeroRepository(heroDao)
            }
            return INSTANCE
        }
    }

    fun getHeroes(): DataSource.Factory<Int, Superhero> {
        return heroDao.getHeroes()
    }

    fun getAntiHeroes(): DataSource.Factory<Int, Superhero> {
        return heroDao.getAntiHeroes()
    }

    fun getVillains(): DataSource.Factory<Int, Superhero> {
        return heroDao.getVillains()
    }

    fun getById(id: Long): LiveData<Superhero> {
        return heroDao.getById(id)
    }

    suspend fun insertSuperheroes(
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