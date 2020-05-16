package com.naufalprakoso.superheroapp.api

import androidx.lifecycle.LiveData
import com.naufalprakoso.superheroapp.data.source.remote.ApiResponse
import com.naufalprakoso.superheroapp.data.source.remote.response.HeroResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperheroService {
    @GET("all.json")
    fun getAll(): LiveData<ApiResponse<List<HeroResponse>>>

    @GET("id/{id}.json")
    fun getById(@Path("id") id: String): LiveData<ApiResponse<HeroResponse>>
}