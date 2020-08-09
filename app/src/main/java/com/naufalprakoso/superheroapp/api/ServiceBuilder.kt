package com.naufalprakoso.superheroapp.api

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.naufalprakoso.superheroapp.livedata.LiveDataCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceBuilder {
    private val baseUrl: String = "https://akabab.github.io/superhero-api/api/"

    private val okHttpClient = OkHttpClient()
        .newBuilder()
        .addNetworkInterceptor(StethoInterceptor())
        .build()

    private val retrofitBuilder: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(baseUrl)
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
    }

    val superheroService: SuperheroService by lazy {
        retrofitBuilder.build().create(SuperheroService::class.java)
    }
}