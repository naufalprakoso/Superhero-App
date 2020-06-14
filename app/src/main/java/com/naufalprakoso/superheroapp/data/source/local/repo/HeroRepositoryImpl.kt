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
import com.naufalprakoso.superheroapp.data.source.remote.response.HeroResponse
import com.naufalprakoso.superheroapp.util.mapper.HeroMapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class HeroRepositoryImpl(
    private val heroDao: HeroDao,
    private val ioScope: CoroutineScope
) : HeroRepository {

    private val heroMapper by lazy {
        HeroMapper()
    }

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

    override fun insertOrUpdate(data: List<HeroResponse>) {
        if (data.isNotEmpty()) {
            val heroes = arrayListOf<Hero>()
            val powerStats = arrayListOf<PowerStat>()
            val works = arrayListOf<Work>()
            val connections = arrayListOf<Connection>()
            val images = arrayListOf<Image>()
            val appearance = arrayListOf<Appearance>()
            val biographies = arrayListOf<Biography>()

            data.forEach { hero ->
                val id = hero.id

                heroes.add(heroMapper.convertToSuperheroEntity(hero))
                powerStats.add(heroMapper.convertResponseToPowerStat(hero.powerStat, id))
                works.add(heroMapper.convertResponseToWork(hero.work, id))
                connections.add(heroMapper.convertResponseToConnection(hero.connection, id))
                images.add(heroMapper.convertResponseToImage(hero.image, id))
                appearance.add(heroMapper.convertResponseToAppearance(hero.appearance, id))
                biographies.add(heroMapper.convertResponseToBiography(hero.biography, id))
            }

            ioScope.launch {
                heroDao.insertSuperheroes(
                    heroes, powerStats, works, biographies,
                    connections, images, appearance
                )
            }
        }
    }
}