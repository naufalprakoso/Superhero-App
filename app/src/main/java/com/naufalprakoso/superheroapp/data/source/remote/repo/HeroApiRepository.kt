package com.naufalprakoso.superheroapp.data.source.remote.repo

import androidx.lifecycle.LiveData
import com.naufalprakoso.superheroapp.data.source.remote.ApiResponse
import com.naufalprakoso.superheroapp.data.source.remote.response.HeroResponse

interface HeroApiRepository {
    fun getAll(): LiveData<ApiResponse<List<HeroResponse>>>?
}