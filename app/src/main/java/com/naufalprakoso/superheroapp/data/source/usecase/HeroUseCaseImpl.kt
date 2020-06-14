package com.naufalprakoso.superheroapp.data.source.usecase

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.naufalprakoso.superheroapp.data.source.NetworkBoundResource
import com.naufalprakoso.superheroapp.data.source.NetworkUtil
import com.naufalprakoso.superheroapp.data.source.local.entity.Appearance
import com.naufalprakoso.superheroapp.data.source.local.entity.Image
import com.naufalprakoso.superheroapp.data.source.local.entity.Work
import com.naufalprakoso.superheroapp.data.source.local.entity.Connection
import com.naufalprakoso.superheroapp.data.source.local.entity.Hero
import com.naufalprakoso.superheroapp.data.source.local.entity.Biography
import com.naufalprakoso.superheroapp.data.source.local.entity.PowerStat
import com.naufalprakoso.superheroapp.data.source.local.relation.Superhero
import com.naufalprakoso.superheroapp.data.source.local.repo.HeroRepository
import com.naufalprakoso.superheroapp.data.source.remote.ApiResponse
import com.naufalprakoso.superheroapp.data.source.remote.repo.HeroApiRepository
import com.naufalprakoso.superheroapp.data.source.remote.response.HeroResponse
import com.naufalprakoso.superheroapp.util.ContextProviders
import com.naufalprakoso.superheroapp.util.mapper.HeroMapper
import com.naufalprakoso.superheroapp.vo.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class HeroUseCaseImpl(
    private val heroRepository: HeroRepository,
    private val heroApiRepository: HeroApiRepository,
    private val ioScope: CoroutineScope,
    private val contextProviders: ContextProviders
) : HeroUseCase {

    private val pagedListConfig = PagedList.Config.Builder()
        .setEnablePlaceholders(false)
        .setPrefetchDistance(30)
        .setPageSize(175)
        .build()

    private val heroMapper by lazy {
        HeroMapper()
    }

    override fun getHeroes(): LiveData<Resource<PagedList<Superhero>>> {
        return object :
            NetworkBoundResource<PagedList<Superhero>, List<HeroResponse>>(contextProviders) {
            override fun loadFromDB(): LiveData<PagedList<Superhero>> {
                return LivePagedListBuilder(heroRepository.getHeroes(), pagedListConfig).build()
            }

            override fun shouldFetch(data: PagedList<Superhero>?): Boolean =
                if (data?.isEmpty() == true) {
                    true
                } else {
                    if (!NetworkUtil.IS_ALREADY_FETCH) {
                        NetworkUtil.IS_ALREADY_FETCH = true
                        true
                    } else {
                        false
                    }
                }

            override fun createCall(): LiveData<ApiResponse<List<HeroResponse>>>? =
                heroApiRepository.getAll()

            override fun saveCallResult(data: List<HeroResponse>) {
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
                    heroRepository.insertSuperheroes(
                        heroes, powerStats, works, biographies,
                        connections, images, appearance
                    )
                }
            }
        }.asLiveData()
    }

    override fun getAntiHeroes(): LiveData<Resource<PagedList<Superhero>>> {
        return object :
            NetworkBoundResource<PagedList<Superhero>, List<HeroResponse>>(contextProviders) {
            override fun loadFromDB(): LiveData<PagedList<Superhero>> {
                return LivePagedListBuilder(heroRepository.getAntiHeroes(), pagedListConfig).build()
            }

            override fun shouldFetch(data: PagedList<Superhero>?): Boolean =
                if (data?.isEmpty() == true) {
                    true
                } else {
                    if (!NetworkUtil.IS_ALREADY_FETCH) {
                        NetworkUtil.IS_ALREADY_FETCH = true
                        true
                    } else {
                        false
                    }
                }

            override fun createCall(): LiveData<ApiResponse<List<HeroResponse>>>? =
                heroApiRepository.getAll()

            override fun saveCallResult(data: List<HeroResponse>) {
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
                    heroRepository.insertSuperheroes(
                        heroes, powerStats, works, biographies,
                        connections, images, appearance
                    )
                }
            }
        }.asLiveData()
    }

    override fun getVillains(): LiveData<Resource<PagedList<Superhero>>> {
        return object :
            NetworkBoundResource<PagedList<Superhero>, List<HeroResponse>>(contextProviders) {
            override fun loadFromDB(): LiveData<PagedList<Superhero>> {
                return LivePagedListBuilder(heroRepository.getVillains(), pagedListConfig).build()
            }

            override fun shouldFetch(data: PagedList<Superhero>?): Boolean =
                if (data?.isEmpty() == true) {
                    true
                } else {
                    if (!NetworkUtil.IS_ALREADY_FETCH) {
                        NetworkUtil.IS_ALREADY_FETCH = true
                        true
                    } else {
                        false
                    }
                }

            override fun createCall(): LiveData<ApiResponse<List<HeroResponse>>>? =
                heroApiRepository.getAll()

            override fun saveCallResult(data: List<HeroResponse>) {
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
                    heroRepository.insertSuperheroes(
                        heroes, powerStats, works, biographies,
                        connections, images, appearance
                    )
                }
            }
        }.asLiveData()
    }

    override fun getHeroById(id: Long): LiveData<Resource<Superhero>> {
        return object :
            NetworkBoundResource<Superhero, HeroResponse>(contextProviders) {
            override fun loadFromDB(): LiveData<Superhero> {
                return heroRepository.getById(id)
            }

            override fun shouldFetch(data: Superhero?): Boolean = false
            override fun createCall(): LiveData<ApiResponse<HeroResponse>>? = null
            override fun saveCallResult(data: HeroResponse) {}
        }.asLiveData()
    }
}