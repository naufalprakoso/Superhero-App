package com.naufalprakoso.superheroapp.api

import com.naufalprakoso.superheroapp.util.LiveDataCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private const val BASE_URL: String = "https://akabab.github.io/superhero-api/api/"

    private val retrofitBuilder: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
    }

    val superheroService: SuperheroService by lazy {
        retrofitBuilder.build().create(SuperheroService::class.java)
    }
}