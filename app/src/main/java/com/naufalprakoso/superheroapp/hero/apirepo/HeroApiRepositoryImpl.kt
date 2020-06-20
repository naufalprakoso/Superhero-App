package com.naufalprakoso.superheroapp.hero.apirepo

import androidx.lifecycle.LiveData
import com.naufalprakoso.superheroapp.api.ServiceBuilder
import com.naufalprakoso.superheroapp.network.ApiResponse
import com.naufalprakoso.superheroapp.network.response.HeroResponse

class HeroApiRepositoryImpl(
    private val serviceBuilder: ServiceBuilder
) : HeroApiRepository {
    override fun getAll(): LiveData<ApiResponse<List<HeroResponse>>>? {
        return serviceBuilder.superheroService.getAll()
    }
}