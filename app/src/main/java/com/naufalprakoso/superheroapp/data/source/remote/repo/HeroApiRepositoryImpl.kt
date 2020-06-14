package com.naufalprakoso.superheroapp.data.source.remote.repo

import androidx.lifecycle.LiveData
import com.naufalprakoso.superheroapp.api.ServiceBuilder
import com.naufalprakoso.superheroapp.data.source.remote.ApiResponse
import com.naufalprakoso.superheroapp.data.source.remote.response.HeroResponse

class HeroApiRepositoryImpl(
    private val serviceBuilder: ServiceBuilder
) : HeroApiRepository {
    override fun getAll(): LiveData<ApiResponse<List<HeroResponse>>>? {
        return serviceBuilder.superheroService.getAll()
    }

}