package com.naufalprakoso.superheroapp.api

import com.naufalprakoso.superheroapp.livedata.LiveDataCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceBuilder {
    private val baseUrl: String = "https://akabab.github.io/superhero-api/api/"

    private val retrofitBuilder: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
    }

    val superheroService: SuperheroService by lazy {
        retrofitBuilder.build().create(SuperheroService::class.java)
    }
}