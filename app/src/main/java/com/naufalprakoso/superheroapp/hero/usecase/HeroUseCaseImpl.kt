package com.naufalprakoso.superheroapp.hero.usecase

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.naufalprakoso.superheroapp.util.NetworkBoundResource
import com.naufalprakoso.superheroapp.util.NetworkUtil
import com.naufalprakoso.superheroapp.database.relation.Superhero
import com.naufalprakoso.superheroapp.hero.repo.HeroRepository
import com.naufalprakoso.superheroapp.network.ApiResponse
import com.naufalprakoso.superheroapp.hero.apirepo.HeroApiRepository
import com.naufalprakoso.superheroapp.network.response.HeroResponse
import com.naufalprakoso.superheroapp.util.ContextProviders
import com.naufalprakoso.superheroapp.vo.Resource

class HeroUseCaseImpl(
    private val heroRepository: HeroRepository,
    private val heroApiRepository: HeroApiRepository,
    private val contextProviders: ContextProviders
) : HeroUseCase {

    private val pagedListConfig = PagedList.Config.Builder()
        .setEnablePlaceholders(false)
        .setPrefetchDistance(30)
        .setPageSize(175)
        .build()

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
                heroRepository.insertOrUpdate(data)
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
                heroRepository.insertOrUpdate(data)
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
                heroRepository.insertOrUpdate(data)
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