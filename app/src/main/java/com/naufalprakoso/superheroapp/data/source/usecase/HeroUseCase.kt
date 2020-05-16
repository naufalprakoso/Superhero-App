package com.naufalprakoso.superheroapp.data.source.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.naufalprakoso.superheroapp.data.source.local.relation.Superhero
import com.naufalprakoso.superheroapp.data.source.local.repo.HeroRepository
import com.naufalprakoso.superheroapp.util.ContextProviders
import com.naufalprakoso.superheroapp.vo.Resource
import kotlinx.coroutines.CoroutineScope

interface HeroUseCase {
    fun getAll(): LiveData<Resource<PagedList<Superhero>>>
}

class HeroUseCaseImpl(
    private val heroRepository: HeroRepository? = null,
    private val ioScope: CoroutineScope? = null,
    private val contextProviders: ContextProviders = ContextProviders()
) : HeroUseCase {
    companion object {
        @Volatile
        private var INSTANCE: HeroUseCase? = null

        fun getInstance(
            heroRepository: HeroRepository?,
            ioScope: CoroutineScope?
        ): HeroUseCase? {
            if (INSTANCE == null) {
                synchronized(HeroUseCase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = HeroUseCaseImpl(heroRepository, ioScope)
                    }
                }
            }
            return INSTANCE
        }
    }

    override fun getAll(): LiveData<Resource<PagedList<Superhero>>> {
        TODO("Not yet implemented")
    }
}