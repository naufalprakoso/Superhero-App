package com.naufalprakoso.superheroapp.hero.usecase

import androidx.lifecycle.LiveData
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

    override fun getHeroes(): LiveData<Resource<List<Superhero>>> {
        return object :
            NetworkBoundResource<List<Superhero>, List<HeroResponse>>(contextProviders) {
            override fun loadFromDB(): LiveData<List<Superhero>> {
                return heroRepository.getHeroes()
            }

            override fun shouldFetch(data: List<Superhero>?): Boolean =
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

    override fun getAntiHeroes(): LiveData<Resource<List<Superhero>>> {
        return object :
            NetworkBoundResource<List<Superhero>, List<HeroResponse>>(contextProviders) {
            override fun loadFromDB(): LiveData<List<Superhero>> {
                return heroRepository.getAntiHeroes()
            }

            override fun shouldFetch(data: List<Superhero>?): Boolean =
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

    override fun getVillains(): LiveData<Resource<List<Superhero>>> {
        return object :
            NetworkBoundResource<List<Superhero>, List<HeroResponse>>(contextProviders) {
            override fun loadFromDB(): LiveData<List<Superhero>> {
                return heroRepository.getVillains()
            }

            override fun shouldFetch(data: List<Superhero>?): Boolean =
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
}