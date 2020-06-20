package com.naufalprakoso.superheroapp.hero.apirepo

import androidx.lifecycle.LiveData
import com.naufalprakoso.superheroapp.network.ApiResponse
import com.naufalprakoso.superheroapp.network.response.HeroResponse

interface HeroApiRepository {
    fun getAll(): LiveData<ApiResponse<List<HeroResponse>>>?
}