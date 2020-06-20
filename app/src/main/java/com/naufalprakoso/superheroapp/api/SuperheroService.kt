package com.naufalprakoso.superheroapp.api

import androidx.lifecycle.LiveData
import com.naufalprakoso.superheroapp.network.ApiResponse
import com.naufalprakoso.superheroapp.network.response.HeroResponse
import retrofit2.http.GET

interface SuperheroService {
    @GET("all.json")
    fun getAll(): LiveData<ApiResponse<List<HeroResponse>>>
}